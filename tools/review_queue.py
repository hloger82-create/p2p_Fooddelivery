#!/usr/bin/env python3
"""Erstellt eine priorisierte Review-Queue aus candidates.json.

Bewertet jeden review-Kandidaten und sortiert die vielversprechendsten zuerst:
Lieferung/Abholung in OSM-Tags, eigener Bestellkanal (Webshop/Telefon),
Impressum gefunden, Koordinaten vorhanden, Website erreichbar.

Usage:
  python3 tools/review_queue.py --candidates data/regions/hannover/candidates.json \
      --out data/regions/hannover/review-queue.md --limit 50
"""

import argparse
import json
import re
import sys
from urllib.parse import urlparse


def score(c: dict) -> int:
    tags = c.get("osmTags", {})
    a = c.get("analysis", {})
    s = 0
    if tags.get("delivery") in ("yes", "only"):
        s += 3
    if tags.get("takeaway") in ("yes", "only"):
        s += 2
    if a.get("orderChannel") == "webshop":
        s += 3
    elif a.get("orderChannel") == "phone" or c.get("phone") or a.get("phone"):
        s += 1
    if a.get("imprintFound"):
        s += 1
    if c.get("lat") and c.get("lon"):
        s += 1
    if not a.get("homepageReachable", True):
        s -= 2
    return s


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--candidates", required=True)
    ap.add_argument("--out", default=None, help="optionale Markdown-Ausgabe")
    ap.add_argument("--limit", type=int, default=0, help="0 = alle")
    ap.add_argument("--restaurants", default=None,
                    help="restaurants.json: Kandidaten mit bereits bekannter Website-Domain ueberspringen (Re-Run)")
    ap.add_argument("--exclude-queue", default=None,
                    help="alte review-queue.md: bereits bearbeitete Faelle (Website-Domain oder Name+PLZ) ueberspringen (Re-Run)")
    args = ap.parse_args()

    with open(args.candidates, encoding="utf-8") as f:
        data = json.load(f)

    def norm_domain(url: str) -> str:
        return urlparse(url).netloc.lower().removeprefix("www.")

    skip_domains = set()
    skip_names = set()
    if args.restaurants:
        with open(args.restaurants, encoding="utf-8") as f:
            for r in json.load(f).get("restaurants", []):
                for u in (r.get("website"), r.get("orderUrl")):
                    if u and str(u).startswith("http"):
                        skip_domains.add(norm_domain(str(u)))
    if args.exclude_queue:
        with open(args.exclude_queue, encoding="utf-8") as f:
            for line in f:
                if not line.startswith("|") or line.startswith("| #") or line.startswith("|---"):
                    continue
                cells = [c.strip() for c in line.strip().strip("|").split("|")]
                if len(cells) < 9:
                    continue
                web = cells[8]
                if web.startswith("http"):
                    skip_domains.add(norm_domain(web))
                skip_names.add((cells[2].lower(), cells[5]))

    def candidate_plz(c: dict) -> str:
        tags = c.get("osmTags", {})
        plz = tags.get("addr:postcode") or ""
        if not plz and c.get("address"):
            m = re.search(r"\b(\d{5})\b", c["address"])
            plz = m.group(1) if m else ""
        return plz

    def known(c: dict) -> bool:
        web = c.get("website") or ""
        if str(web).startswith("http") and norm_domain(str(web)) in skip_domains:
            return True
        return (str(c.get("name", "")).lower(), candidate_plz(c)) in skip_names

    # review + auto_accept: auto_accept faellt nicht ins manuelle Review, muss aber gemergt werden
    # (mit merge_candidates.py --auto-verify werden die eindeutigen Faelle direkt verified)
    all_reviews = [c for c in data.get("candidates", []) if c.get("status") in ("review", "auto_accept")]
    reviews = [c for c in all_reviews if not known(c)]
    skipped = len(all_reviews) - len(reviews)
    reviews.sort(key=score, reverse=True)
    if args.limit > 0:
        reviews = reviews[: args.limit]

    lines = [
        f"# Review-Queue {data.get('regionId', '?')} ({len(reviews)} neue Faelle [review/auto_accept], {skipped} bereits bekannte uebersprungen, sortiert nach Score)",
        "",
        "Score: delivery-Tag +3, eigener Webshop +3, takeaway-Tag +2, Telefon +1, Impressum +1, Koords +1, Website down -2.",
        "",
        "QS-Checkliste pro Fall: 1) PLZ in Regionsliste + BBox, 2) Impressum + eigener Kanal (kein Plattform-Redirect, keine plattform-betriebene Seite wie 'betrieben und verwaltet durch Lieferando.de'), 3) **Kueche**: `cuisineSource=stated` uebernehmen; nicht angegeben -> Speisen analysieren, eigene Schlussfolgerung (`cuisines` setzen, `cuisineSource=derived`, Vermerk in `notes`), 4) delivers/pickup nur mit Nachweis (WEBSHOP nur mit echtem Shop - Gutscheine-only zaehlt nicht), 5) **keine Website = Ausschluss** (Link-Out-App), 6) **weder Lieferung noch Abholung = Ausschluss** (Telefon dann vermutlich nur Reservierung), 7) `status=verified` + `lastVerified` setzen.",
        "",
        "| # | Score | Name | Kanal | Kueche | PLZ | Impressum | Koords | Website | Reasons |",
        "|---|-------|------|-------|--------|-----|-----------|--------|---------|--------|",
    ]
    for i, c in enumerate(reviews, 1):
        a = c.get("analysis", {})
        plz = candidate_plz(c)
        reasons = "; ".join(c.get("reasons", []))[:80]
        lines.append(
            f"| {i} | {score(c)} | {c.get('name','?')} | {a.get('orderChannel') or '-'} | "
            f"{','.join(c.get('cuisines', []))} | {plz} | {'ja' if a.get('imprintFound') else 'nein'} | "
            f"{'ja' if c.get('lat') else 'nein'} | {c.get('website') or '-'} | {reasons} |"
        )

    out = "\n".join(lines) + "\n"
    if args.out:
        with open(args.out, "w", encoding="utf-8") as f:
            f.write(out)
        print(f"geschrieben: {args.out} ({len(reviews)} Eintraege)")
    else:
        print(out)
    return 0


if __name__ == "__main__":
    sys.exit(main())
