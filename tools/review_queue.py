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
    args = ap.parse_args()

    with open(args.candidates, encoding="utf-8") as f:
        data = json.load(f)

    reviews = [c for c in data.get("candidates", []) if c.get("status") == "review"]
    reviews.sort(key=score, reverse=True)
    if args.limit > 0:
        reviews = reviews[: args.limit]

    lines = [
        f"# Review-Queue {data.get('regionId', '?')} ({len(reviews)} Faelle, sortiert nach Score)",
        "",
        "Score: delivery-Tag +3, eigener Webshop +3, takeaway-Tag +2, Telefon +1, Impressum +1, Koords +1, Website down -2.",
        "",
        "QS-Checkliste pro Fall: 1) PLZ in Regionsliste + BBox, 2) Impressum + eigener Kanal (kein Plattform-Redirect), 3) **Kueche**: `cuisineSource=stated` uebernehmen; nicht angegeben -> Speisen analysieren, eigene Schlussfolgerung (`cuisines` setzen, `cuisineSource=derived`, Vermerk in `notes`), 4) delivers/pickup nur mit Nachweis, 5) `status=verified` + `lastVerified` setzen.",
        "",
        "| # | Score | Name | Kanal | Kueche | PLZ | Impressum | Koords | Website | Reasons |",
        "|---|-------|------|-------|--------|-----|-----------|--------|---------|--------|",
    ]
    for i, c in enumerate(reviews, 1):
        a = c.get("analysis", {})
        tags = c.get("osmTags", {})
        addr = c.get("address", "")
        plz = tags.get("addr:postcode") or ""
        if not plz and addr:
            import re
            m = re.search(r"\b(\d{5})\b", addr)
            plz = m.group(1) if m else ""
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
