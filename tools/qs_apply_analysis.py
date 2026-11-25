#!/usr/bin/env python3
"""QS-Tool: wendet die Pipeline-Website-Analyse auf restaurants.json an und entfernt Plattform-Eintraege.

Entfernt Eintraege, bei denen die Analyse der eigenen Startseite ergibt:
  - platformManaged (Seite wird von Plattform verwaltet, z. B. "verwaltet durch Lieferando.de") -> immer entfernt
  - platformLinkOnHomepage (Startseite verlinkt auf Plattform-Domain) UND kein eigener Webshop -> entfernt
    (mit eigenem Webshop bleibt der Eintrag, wird aber als 'behalten trotz Plattform-Link' gelistet)

Vorher Pipeline laufen lassen (Cache wird wiederverwendet):
  python3 tools/research_pipeline.py --region data/regions/hannover/region.json --out data/regions/hannover/candidates.json --max 0 --delay 1.0

Usage:
  python3 tools/qs_apply_analysis.py --restaurants data/regions/hannover/restaurants.json \
      --candidates data/regions/hannover/candidates.json [--dry-run]
"""

import argparse
import json
import re
import sys
from urllib.parse import urlparse


def host(u):
    return urlparse(u or "").netloc.lower().removeprefix("www.")


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("--restaurants", required=True)
    ap.add_argument("--candidates", required=True)
    ap.add_argument("--dry-run", action="store_true")
    args = ap.parse_args()

    with open(args.restaurants, encoding="utf-8") as f:
        ds = json.load(f)
    with open(args.candidates, encoding="utf-8") as f:
        cands = json.load(f).get("candidates", [])

    by_osm = {c.get("osmId"): c for c in cands if c.get("osmId")}
    by_dom = {}
    for c in cands:
        w = c.get("website")
        if w:
            by_dom[host(w)] = c

    def cand_of(r):
        m = re.search(r"pipeline (\S+?);", r.get("notes") or "")
        if m and m.group(1) in by_osm:
            return by_osm[m.group(1)]
        return by_dom.get(host(r.get("website")))

    removed, kept_link = [], []
    out = []
    for r in ds.get("restaurants", []):
        c = cand_of(r)
        a = (c or {}).get("analysis", {}) if c else {}
        # platformManaged nur werten, wenn eine echte Domain erkannt wurde (kein Klartext wie "powered by")
        pm = a.get("platformManaged")
        if pm and "." in str(pm):
            removed.append((r["id"], f"Seite wird von Plattform verwaltet ({pm})"))
            continue
        # Plattform-Link auf Startseite: nur entfernen, wenn der Eintrag KEINEN eigenen Webshop behauptet
        # (manuelle Verifizierung im Eintrag schlaegt Pipeline-Heuristik)
        if a.get("platformLinkOnHomepage") and "WEBSHOP" not in r.get("orderTypes", []):
            removed.append((r["id"], f"Startseite verlinkt {a.get('platformLinkOnHomepage')}, kein eigener Webshop"))
            continue
        if a.get("platformLinkOnHomepage"):
            kept_link.append((r["id"], a.get("platformLinkOnHomepage")))
        out.append(r)

    ds["restaurants"] = out
    print(f"entfernt: {len(removed)}")
    for rid, why in removed:
        print(f"  - {rid}: {why}")
    print(f"behalten trotz Plattform-Link (eigener Webshop vorhanden): {len(kept_link)}")
    for rid, dom in kept_link[:20]:
        print(f"  = {rid}: {dom}")

    if not args.dry_run and removed:
        with open(args.restaurants, "w", encoding="utf-8") as f:
            f.write(json.dumps(ds, ensure_ascii=False, indent=2) + "\n")
        # Assets spiegeln
        region_id = ds.get("regionId", "hannover")
        asset = f"app/src/main/assets/regions/{region_id}/restaurants.json"
        with open(asset, "w", encoding="utf-8") as f:
            f.write(json.dumps(ds, ensure_ascii=False, indent=2) + "\n")
        print(f"geschrieben: {args.restaurants} + {asset} ({len(out)} Eintraege)")
    elif args.dry_run:
        print("dry-run: nichts geschrieben")
    return 0


if __name__ == "__main__":
    sys.exit(main())
