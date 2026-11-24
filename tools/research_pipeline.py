#!/usr/bin/env python3
"""Recherche-Pipeline fuer p2p_Fooddelivery.

Sucht Kandidaten-Restaurants in einer Region (OpenStreetMap via Overpass),
prueft deren eigene Websites und erzeugt eine bewertete Kandidatenliste.

Rechtlicher Rahmen (bewusst restriktiv):
  - nur oeffentlich zugaengliche Seiten der Restaurants selbst
  - robots.txt wird respektiert, Rate-Limiting pro Domain, eigener User-Agent
  - keine Plattformen (Lieferando, Wolt, ...) werden ausgelesen, deren Seiten
    werden nur als Redirect-Ziel erkannt und markiert (Blocklist)
  - keine personenbezogenen Daten werden gespeichert (nur oeffentliche
    Geschaeftsdaten: Firma, Adresse, Telefon, Website)

Usage:
  python3 tools/research_pipeline.py --region data/regions/hannover/region.json \
      --out data/regions/hannover/candidates.json --max 60 --delay 1.0
"""

import argparse
import json
import re
import sys
import time
import urllib.robotparser
import urllib.parse
from datetime import date

import requests

OVERPASS_URL = "https://overpass-api.de/api/interpreter"
OVERPASS_FALLBACKS = [
    "https://overpass.kumi.systems/api/interpreter",
    "https://overpass.private.coffee/api/interpreter",
    "https://overpass.openstreetmap.fr/api/interpreter",
    "https://overpass.osm.ch/api/interpreter",
]
NOMINATIM_URL = "https://nominatim.openstreetmap.org/search"
USER_AGENT = (
    "p2p-fooddelivery-research/0.1 "
    "(+https://github.com/hloger82-create/p2p_Fooddelivery; contact: research@example.invalid)"
)

CUISINE_MAP = {
    "pizza": "PIZZA", "italian": "ITALIAN", "pasta": "ITALIAN",
    "kebab": "DOENER", "doner": "DOENER", "turkish": "TURKISH", "greek": "GREEK",
    "burger": "BURGER", "american": "AMERICAN", "grill": "GRILL",
    "sushi": "SUSHI", "japanese": "ASIAN", "chinese": "CHINESE", "thai": "THAI",
    "vietnamese": "VIETNAMESE", "indian": "INDIAN", "asian": "ASIAN",
    "mexican": "MEXICAN", "falafel": "DOENER",
}

WEBSHOP_HINTS = [
    "woocommerce", "shopify", "shopware", "simplywebshop", "app-smart",
    "restablo", "woocommerce", "xt:commerce", "modified", "oxid",
    "warenkorb", "cart", "checkout", "bestellshop", "webshop",
]
FORM_HINTS = ["bestellformular", "kontaktformular", "mailto:", "anfrageformular", "bestellung per formular"]
IMPRINT_HINTS = [
    "impressum", "imprint", "legal notice", "angaben gemäß", "angaben gemaess",
    "§ 5 tmg", "5 tmg", "verantwortlich", "handelsregister", "hrb",
    "ust-idnr", "umsatzsteuer-id", "geschäftsführer", "inhaber",
]
ORDER_LINK_HINTS = ["bestellen", "bestellung", "order", "webshop", "shop", "lieferservice", "lieferdienst", "bringdienst", "menu", "speisekarte"]
DELIVERY_HINTS = ["liefergebiet", "liefern wir", "wir liefern", "delivery area", "liefern nach"]

MAX_HTML_BYTES = 500_000


def domain_of(url: str) -> str:
    return urllib.parse.urlparse(url).netloc.lower().removeprefix("www.")


def is_blocked(url: str, blocklist) -> bool:
    d = domain_of(url)
    return any(d == b or d.endswith("." + b) for b in blocklist)


def robots_allows(session: requests.Session, url: str) -> bool:
    parsed = urllib.parse.urlparse(url)
    robots_url = f"{parsed.scheme}://{parsed.netloc}/robots.txt"
    rp = urllib.robotparser.RobotFileParser()
    try:
        resp = session.get(robots_url, timeout=10, allow_redirects=True)
        rp.parse(resp.text.splitlines())
    except Exception:
        return True
    return rp.can_fetch(USER_AGENT, url)


def fetch(session: requests.Session, url: str, delay: float) -> requests.Response | None:
    if not robots_allows(session, url):
        return None
    time.sleep(delay)
    try:
        return session.get(url, timeout=20, allow_redirects=False, stream=True)
    except requests.RequestException:
        return None


def redirect_chain(session: requests.Session, url: str, delay: float, max_hops: int = 6):
    """Folgt Redirects manuell und liefert (chain, final_url, blocked_hit)."""
    chain = [url]
    current = url
    for _ in range(max_hops):
        if is_blocked(current, session.blocklist):
            return chain, current, current
        resp = fetch(session, current, delay)
        if resp is None:
            return chain, current, None
        if resp.is_redirect or resp.is_permanent_redirect:
            location = resp.headers.get("Location")
            resp.close()
            if not location:
                return chain, current, None
            current = urllib.parse.urljoin(current, location)
            chain.append(current)
            continue
        resp.close()
        return chain, current, None
    return chain, current, None


def extract_links(html: str, base: str, hints, same_domain_only=True, limit=10):
    out = []
    for href in re.findall(r'href=["\']([^"\']+)["\']', html, flags=re.I):
        low = href.lower()
        if not any(h in low for h in hints):
            continue
        abs_url = urllib.parse.urljoin(base, href)
        if same_domain_only and domain_of(abs_url) != domain_of(base):
            continue
        if abs_url not in out:
            out.append(abs_url)
        if len(out) >= limit:
            break
    return out


def extract_jsonld(html: str):
    data = []
    for block in re.findall(r'<script[^>]*type=["\']application/ld\+json["\'][^>]*>(.*?)</script>', html, flags=re.I | re.S):
        try:
            parsed = json.loads(block.strip())
        except json.JSONDecodeError:
            continue
        items = parsed if isinstance(parsed, list) else [parsed]
        for item in items:
            if isinstance(item, dict):
                if "@graph" in item and isinstance(item["@graph"], list):
                    data.extend(x for x in item["@graph"] if isinstance(x, dict))
                else:
                    data.append(item)
    return data


def find_business(jsonld_items):
    for item in jsonld_items:
        t = item.get("@type")
        types = t if isinstance(t, list) else [t]
        if any(x in ("Restaurant", "LocalBusiness", "FoodEstablishment") for x in types):
            return item
    return None


def analyze_website(session: requests.Session, website: str, region: dict, delay: float) -> dict:
    """Prueft die eigene Website eines Restaurants. Liefert Analyse-Dict."""
    result = {
        "website": website,
        "homepageReachable": False,
        "imprintFound": False,
        "orderChannel": None,
        "orderRedirectsToPlatform": False,
        "platformHit": None,
        "phone": None,
        "openingHours": None,
        "servesCuisine": [],
        "deliveryMentioned": False,
        "deliveryPostcodes": [],
        "orderLinks": [],
    }
    resp = fetch(session, website, delay)
    if resp is None or not (200 <= resp.status_code < 300):
        return result
    result["homepageReachable"] = True
    html = resp.text[:MAX_HTML_BYTES]
    resp.close()

    tel = re.findall(r'href=["\']tel:([^"\']+)["\']', html, flags=re.I)
    if tel:
        result["phone"] = tel[0]

    business = find_business(extract_jsonld(html))
    if business:
        if not result["phone"] and business.get("telephone"):
            result["phone"] = str(business["telephone"])
        if business.get("openingHours"):
            result["openingHours"] = str(business["openingHours"])
        cuisine = business.get("servesCuisine")
        if isinstance(cuisine, list):
            result["servesCuisine"] = [str(c) for c in cuisine]
        elif isinstance(cuisine, str):
            result["servesCuisine"] = [cuisine]

    low = html.lower()
    imprint_links = extract_links(html, website, ["impressum", "imprint", "legal"], limit=5)
    if imprint_links or "impressum" in low:
        result["imprintFound"] = True
        for link in imprint_links[:3]:
            page = fetch(session, link, delay)
            if page is None or not (200 <= page.status_code < 300):
                continue
            body = page.text[:MAX_HTML_BYTES].lower()
            page.close()
            hits = sum(1 for h in IMPRINT_HINTS if h in body)
            if hits >= 2:
                result["imprintFound"] = True
                break

    order_links = extract_links(html, website, ORDER_LINK_HINTS, same_domain_only=False, limit=10)
    result["orderLinks"] = order_links
    platform_hit = None
    own_shop = False
    form_only = False
    for link in order_links[:6]:
        chain, final, blocked = redirect_chain(session, link, delay)
        if blocked and is_blocked(blocked, session.blocklist):
            platform_hit = blocked
            continue
        if domain_of(final) != domain_of(website):
            continue
        page = fetch(session, final, delay)
        if page is None or not (200 <= page.status_code < 300):
            continue
        body = page.text[:MAX_HTML_BYTES].lower()
        page.close()
        if any(h in body for h in WEBSHOP_HINTS):
            own_shop = True
        if any(h in body for h in FORM_HINTS):
            form_only = True
    if any(h in low for h in WEBSHOP_HINTS):
        own_shop = True
    if any(h in low for h in FORM_HINTS):
        form_only = True

    if platform_hit:
        result["orderRedirectsToPlatform"] = True
        result["platformHit"] = platform_hit
        result["orderChannel"] = "platform_only"
    elif own_shop:
        result["orderChannel"] = "webshop"
    elif form_only:
        result["orderChannel"] = "form"
    elif result["phone"]:
        result["orderChannel"] = "phone"

    if any(h in low for h in DELIVERY_HINTS):
        result["deliveryMentioned"] = True
    prefixes = region.get("postcodePrefixes", [])
    plzs = set(re.findall(r"\b(\d{5})\b", html))
    result["deliveryPostcodes"] = sorted(p for p in plzs if any(p.startswith(pre) for pre in prefixes))
    return result


def build_overpass_query(region: dict, limit: int, query_timeout: int = 15) -> str:
    if region.get("bbox"):
        south, west, north, east = region["bbox"]
        area = f"({south},{west},{north},{east})"
        return (
            f'[out:json][timeout:{query_timeout}];'
            f'(node["amenity"~"^(restaurant|fast_food)$"]{area};way["amenity"~"^(restaurant|fast_food)$"]{area};);'
            f'out tags center {limit};'
        )
    if region.get("osmAreaName"):
        return (
            f'[out:json][timeout:{query_timeout}];area["name"="{region["osmAreaName"]}"]["boundary"="administrative"]->.a;'
            f'(node["amenity"~"^(restaurant|fast_food)$"](area.a);way["amenity"~"^(restaurant|fast_food)$"](area.a););'
            f'out tags center {limit};'
        )
    raise SystemExit("region.json braucht bbox oder osmAreaName")


def overpass_candidates(region: dict, limit: int, overpass_url: str) -> list:
    query = build_overpass_query(region, limit)
    endpoints = [overpass_url] + [u for u in OVERPASS_FALLBACKS if u != overpass_url]
    last_exc = None
    for endpoint in endpoints:
        for attempt in (1, 2, 3):
            try:
                resp = requests.post(
                    endpoint,
                    data={"data": query},
                    headers={"User-Agent": USER_AGENT},
                    timeout=45,
                )
                resp.raise_for_status()
                print(f"  Overpass OK via {endpoint}")
                return resp.json().get("elements", [])
            except requests.RequestException as e:
                last_exc = e
                wait = 10
                if isinstance(e, requests.HTTPError) and e.response is not None:
                    retry_after = e.response.headers.get("Retry-After")
                    if retry_after and retry_after.isdigit():
                        wait = max(wait, min(int(retry_after), 120))
                    if e.response.status_code == 429:
                        wait = max(wait, 30)
                print(f"  Overpass {endpoint} Versuch {attempt} fehlgeschlagen: {e} (pause {wait}s)")
                time.sleep(wait)
    raise last_exc


def geocode(session: requests.Session, address: str, delay: float):
    time.sleep(max(delay, 1.0))
    try:
        resp = session.get(
            NOMINATIM_URL,
            params={"q": address, "format": "json", "limit": 1, "countrycodes": "de"},
            timeout=15,
        )
        resp.raise_for_status()
        rows = resp.json()
        if rows:
            return float(rows[0]["lat"]), float(rows[0]["lon"])
    except Exception:
        return None
    return None


def classify_cuisines(tags: dict, analysis: dict) -> list:
    cuisines = set()
    raw = tags.get("cuisine", "")
    for part in re.split(r"[;,]", raw):
        key = part.strip().lower()
        if key in CUISINE_MAP:
            cuisines.add(CUISINE_MAP[key])
    for c in analysis.get("servesCuisine", []):
        key = c.strip().lower()
        if key in CUISINE_MAP:
            cuisines.add(CUISINE_MAP[key])
    if not cuisines:
        cuisines.add("OTHER")
    return sorted(cuisines)


def score_candidate(tags: dict, analysis: dict, region: dict) -> dict:
    reasons = []
    checks = {
        "hasWebsite": bool(tags.get("website") or tags.get("contact:website")),
        "homepageReachable": analysis.get("homepageReachable", False),
        "imprintFound": analysis.get("imprintFound", False),
        "notPlatformOnly": analysis.get("orderChannel") not in (None, "platform_only"),
        "hasOrderChannel": analysis.get("orderChannel") is not None,
        "inRegionPostcode": True,
    }
    if not checks["hasWebsite"]:
        reasons.append("keine Website in OSM hinterlegt")
    if checks["hasWebsite"] and not checks["homepageReachable"]:
        reasons.append("Website nicht erreichbar")
    if not checks["imprintFound"]:
        reasons.append("kein Impressum gefunden (oder nicht erreichbar)")
    if analysis.get("orderRedirectsToPlatform"):
        reasons.append(f"Bestell-Link fuehrt zu Plattform: {analysis.get('platformHit')}")
    if not checks["hasOrderChannel"]:
        reasons.append("kein eigener Bestellkanal erkannt (Webshop/Formular/Telefon)")

    if analysis.get("orderRedirectsToPlatform") and not checks["notPlatformOnly"]:
        status = "reject"
    elif all(checks.values()):
        status = "auto_accept"
    else:
        status = "review"
    return {"checks": checks, "reasons": reasons, "status": status}


def main():
    ap = argparse.ArgumentParser(description="p2p_Fooddelivery Recherche-Pipeline")
    ap.add_argument("--region", required=True, help="Pfad zu region.json")
    ap.add_argument("--out", required=True, help="Zieldatei fuer Kandidaten (JSON)")
    ap.add_argument("--max", type=int, default=60, help="max. OSM-Kandidaten")
    ap.add_argument("--delay", type=float, default=1.0, help="Sekunden Pause zwischen Requests pro Domain")
    ap.add_argument("--skip-website-check", action="store_true", help="nur OSM-Daten, keine Website-Analyse")
    ap.add_argument("--overpass", default=OVERPASS_URL, help="Overpass-API-Endpunkt (Fallbacks werden automatisch probiert)")
    args = ap.parse_args()

    with open(args.region, encoding="utf-8") as f:
        region = json.load(f)
    blocklist = region.get("platformBlocklist", [])

    session = requests.Session()
    session.headers.update({"User-Agent": USER_AGENT})
    session.blocklist = blocklist

    print(f"[1/3] Overpass-Abfrage fuer Region '{region['id']}' (max {args.max}) ...")
    elements = overpass_candidates(region, args.max, args.overpass)
    print(f"      {len(elements)} OSM-Elemente gefunden")

    candidates = []
    for i, el in enumerate(elements, 1):
        tags = el.get("tags", {})
        name = tags.get("name")
        if not name:
            continue
        website = tags.get("website") or tags.get("contact:website")
        lat = el.get("lat") or (el.get("center") or {}).get("lat")
        lon = el.get("lon") or (el.get("center") or {}).get("lon")
        address = ", ".join(
            p for p in [tags.get("addr:housenumber", "") + " " + tags.get("addr:street", ""), tags.get("addr:postcode", ""), tags.get("addr:city", "") or region["name"]] if p.strip()
        )
        entry = {
            "osmId": f"{el['type']}/{el['id']}",
            "name": name,
            "website": website,
            "phone": tags.get("phone") or tags.get("contact:phone"),
            "address": address.strip(", "),
            "lat": lat,
            "lon": lon,
            "osmTags": {k: v for k, v in tags.items() if k in ("cuisine", "opening_hours", "delivery", "takeaway", "addr:housenumber", "addr:street", "addr:postcode", "addr:city")},
        }
        if not website:
            entry["analysis"] = {"orderChannel": None, "orderRedirectsToPlatform": False}
            entry["cuisines"] = classify_cuisines(tags, entry["analysis"])
            entry.update(score_candidate(tags, entry["analysis"], region))
            candidates.append(entry)
            continue
        if lat is None or lon is None:
            geo = geocode(session, address, args.delay)
            if geo:
                entry["lat"], entry["lon"] = geo
        print(f"[{i}/{len(elements)}] analysiere {name} ({website})")
        if args.skip_website_check:
            analysis = {"orderChannel": None, "orderRedirectsToPlatform": False, "homepageReachable": False, "imprintFound": False}
        else:
            analysis = analyze_website(session, website, region, args.delay)
            if entry["phone"] is None and analysis.get("phone"):
                entry["phone"] = analysis["phone"]
        entry["analysis"] = analysis
        entry["cuisines"] = classify_cuisines(tags, analysis)
        entry.update(score_candidate(tags, analysis, region))
        candidates.append(entry)

    summary = {"auto_accept": 0, "review": 0, "reject": 0}
    for c in candidates:
        summary[c["status"]] = summary.get(c["status"], 0) + 1

    out = {
        "regionId": region["id"],
        "generatedAt": date.today().isoformat(),
        "legalNote": "Nur oeffentliche Geschaeftsdaten; robots.txt respektiert; keine Plattform-Inhalte ausgelesen. Manuelle Endpruefung vor Veroeffentlichung erforderlich.",
        "summary": summary,
        "candidates": candidates,
    }
    with open(args.out, "w", encoding="utf-8") as f:
        json.dump(out, f, ensure_ascii=False, indent=2)
    print(f"[3/3] Ergebnis: {summary} -> {args.out}")


if __name__ == "__main__":
    sys.exit(main())
