#!/usr/bin/env python3
"""Uebernimmt Pipeline-Kandidaten in das Restaurant-Dataset.

Liest candidates.json (Output von research_pipeline.py) und fuegt alle
Kandidaten mit Status auto_accept/review als neue Eintraege in
restaurants.json ein. Status bleibt pending_review (manuelle Endpruefung
vor Veroeffentlichung, siehe docs/LEGAL.md). Duplikate werden anhand der
Website-Domain bzw. des Namens erkannt.

Usage:
  python3 tools/merge_candidates.py \
      --candidates data/regions/hannover/candidates.json \
      --out data/regions/hannover/restaurants.json
"""

import argparse
import json
import re
import sys
import unicodedata
from urllib.parse import urlparse

CHANNEL_TO_TYPES = {
    "webshop": ["WEBSHOP"],
    "phone": ["PHONE"],
}


def slugify(name: str) -> str:
    name = unicodedata.normalize("NFKD", name).encode("ascii", "ignore").decode()
    return re.sub(r"[^a-z0-9]+", "-", name.lower()).strip("-") or "restaurant"


def domain(url):
    if not url:
        return None
    return urlparse(url).netloc.lower().removeprefix("www.")


def parse_address(tags: dict, address: str, region_name: str):
    street = tags.get("addr:street")
    housenumber = tags.get("addr:housenumber")
    if street:
        street = f"{street} {housenumber}".strip() if housenumber else street
    postcode = tags.get("addr:postcode")
    if not postcode and address:
        m = re.search(r"\b(\d{5})\b", address)
        postcode = m.group(1) if m else None
    if not street and address:
        street = address.split(",")[0].strip() or None
    return {"street": street, "postcode": postcode, "city": tags.get("addr:city") or region_name}


def candidate_to_entry(c: dict, region_id: str, region_name: str, existing_ids: set):
    tags = c.get("osmTags", {})
    analysis = c.get("analysis", {})
    channel = analysis.get("orderChannel")
    order_types = list(CHANNEL_TO_TYPES.get(channel, []))
    takeaway = tags.get("takeaway") in ("yes", "only")
    if takeaway and "PICKUP" not in order_types:
        order_types.append("PICKUP")
    delivers = tags.get("delivery") == "yes" or bool(analysis.get("deliveryMentioned"))

    base_id = f"{region_id}-{slugify(c['name'])}"
    rid = base_id
    suffix = 2
    while rid in existing_ids:
        rid = f"{base_id}-{suffix}"
        suffix += 1
    existing_ids.add(rid)

    checks = c.get("checks", {})
    reasons = c.get("reasons", [])
    return {
        "id": rid,
        "regionId": region_id,
        "name": c["name"],
        "address": parse_address(tags, c.get("address", ""), region_name),
        "lat": c.get("lat"),
        "lon": c.get("lon"),
        "phone": c.get("phone") or analysis.get("phone"),
        "website": c.get("website"),
        "orderUrl": c.get("website"),
        "orderTypes": order_types or ["PHONE"],
        "cuisines": c.get("cuisines") or ["OTHER"],
        "openingHours": tags.get("opening_hours") or analysis.get("openingHours"),
        "delivers": delivers,
        "pickup": takeaway or not delivers,
        "deliveryAreas": analysis.get("deliveryPostcodes", []),
        "minOrderValue": None,
        "deliveryFee": None,
        "status": "pending_review",
        "lastVerified": None,
        "source": "pipeline",
        "notes": f"pipeline {c.get('osmId','')}; checks={json.dumps(checks, ensure_ascii=False)}; reasons={json.dumps(reasons, ensure_ascii=False)}",
    }


def main() -> int:
    ap = argparse.ArgumentParser(description="Merge Pipeline-Kandidaten in restaurants.json")
    ap.add_argument("--candidates", required=True, action="append", help="candidates.json (mehrfach angebbar, z. B. fuer Slices)")
    ap.add_argument("--out", required=True, help="bestehende restaurants.json (wird erweitert)")
    ap.add_argument("--region", default=None, help="region.json fuer Regionsname (optional)")
    ap.add_argument("--min-status", default="review", choices=["auto_accept", "review"],
                    help="nur Kandidaten ab diesem Status mergen (auto_accept = nur automatisch bestandene Checks)")
    args = ap.parse_args()

    all_candidates = []
    region_id = "unknown"
    for cpath in args.candidates:
        with open(cpath, encoding="utf-8") as f:
            cand = json.load(f)
        region_id = cand.get("regionId", region_id)
        all_candidates.extend(cand.get("candidates", []))
    region_name = region_id
    if args.region:
        with open(args.region, encoding="utf-8") as f:
            region_name = json.load(f).get("name", region_id)

    try:
        with open(args.out, encoding="utf-8") as f:
            dataset = json.load(f)
    except FileNotFoundError:
        dataset = {"regionId": region_id, "generatedAt": "", "restaurants": []}
    dataset.setdefault("restaurants", [])

    existing_ids = {r["id"] for r in dataset["restaurants"]}
    existing_domains = {domain(r.get("website")) for r in dataset["restaurants"]} - {None}

    added, skipped_dup, skipped_reject = 0, 0, 0
    rank = {"auto_accept": 2, "review": 1, "reject": 0}
    min_rank = rank[args.min_status]
    for c in all_candidates:
        status = c.get("status")
        if rank.get(status, 0) < min_rank:
            skipped_reject += 1
            continue
        if not c.get("checks", {}).get("hasWebsite"):
            skipped_reject += 1
            continue
        if domain(c.get("website")) in existing_domains:
            skipped_dup += 1
            continue
        entry = candidate_to_entry(c, region_id, region_name, existing_ids)
        dataset["restaurants"].append(entry)
        existing_domains.add(domain(c.get("website")))
        added += 1

    dataset["restaurants"].sort(key=lambda r: r["name"].lower())
    with open(args.out, "w", encoding="utf-8") as f:
        json.dump(dataset, f, ensure_ascii=False, indent=2)
        f.write("\n")

    print(f"added={added} skipped_duplicates={skipped_dup} skipped_reject/no_website={skipped_reject} -> {args.out}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
