#!/usr/bin/env python3
"""Wendet Abhak-Markierungen aus einer pending-review.md auf restaurants.json an.

Konvention in der Queue-Tabelle (erste Spalte):
  [x] = Eintrag verifizieren: status=verified, lastVerified=<heute/--date>, Vermerk in notes
  [r] = Eintrag entfernen (Reject)
  [ ] = nichts tun

Assets werden automatisch gespiegelt. Danach validate_data.py laufen lassen, committen, pushen.

Usage:
  python3 tools/review_apply.py --queue data/regions/hannover/pending-review.md \
      --restaurants data/regions/hannover/restaurants.json [--date 2026-11-26] [--dry-run]
"""

import argparse
import json
import sys
from datetime import date


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--queue", required=True)
    ap.add_argument("--restaurants", required=True)
    ap.add_argument("--date", default=None, help="lastVerified-Datum (Default: heute)")
    ap.add_argument("--dry-run", action="store_true")
    args = ap.parse_args()

    verdict_date = args.date or date.today().isoformat()

    with open(args.queue, encoding="utf-8") as f:
        queue_lines = f.readlines()
    with open(args.restaurants, encoding="utf-8") as f:
        ds = json.load(f)

    by_id = {r["id"]: r for r in ds.get("restaurants", [])}
    verified, removed, unknown = [], [], []

    for line in queue_lines:
        if not line.startswith("| ["):
            continue
        cells = [c.strip() for c in line.strip().strip("|").split("|")]
        if len(cells) < 3 or cells[1] == "ID":  # Header-Zeile ueberspringen
            continue
        mark, rid = cells[0], cells[1]
        r = by_id.get(rid)
        if r is None:
            if mark in ("[x]", "[r]"):
                unknown.append(rid)
            continue
        if mark == "[x]":
            r["status"] = "verified"
            r["lastVerified"] = verdict_date
            r["notes"] = ((r.get("notes") or "") + f" | Review {verdict_date}").strip(" |")
            verified.append(rid)
        elif mark == "[r]":
            removed.append(rid)

    if removed:
        gone = set(removed)
        ds["restaurants"] = [r for r in ds["restaurants"] if r["id"] not in gone]

    print(f"verified: {len(verified)} | entfernt: {len(removed)} | unbekannte IDs: {len(unknown)}")
    for rid in verified[:15]:
        print(f"  [x] {rid}")
    for rid in removed[:15]:
        print(f"  [r] {rid}")
    if unknown:
        print(f"  ?? {unknown}")

    if args.dry_run:
        print("dry-run: nichts geschrieben")
        return 0
    if not verified and not removed:
        print("nichts zu tun")
        return 0

    with open(args.restaurants, "w", encoding="utf-8") as f:
        f.write(json.dumps(ds, ensure_ascii=False, indent=2) + "\n")
    written = args.restaurants
    # Assets nur spiegeln, wenn die data/regions/...-Datei bearbeitet wurde (nicht bei temp-Kopien)
    if args.restaurants.replace("\\", "/").startswith("data/regions/"):
        region_id = ds.get("regionId", "hannover")
        asset = f"app/src/main/assets/regions/{region_id}/restaurants.json"
        with open(asset, "w", encoding="utf-8") as f:
            f.write(json.dumps(ds, ensure_ascii=False, indent=2) + "\n")
        written += " + " + asset
    print(f"geschrieben: {written} ({len(ds['restaurants'])} Eintraege)")
    return 0


if __name__ == "__main__":
    sys.exit(main())
