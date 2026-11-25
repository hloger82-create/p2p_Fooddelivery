#!/usr/bin/env python3
"""Checkliste aller noch nicht verifizierten Eintraege (status != verified) aus restaurants.json.

Ausgabe: Markdown-Tabelle zum Abhaken, sortiert nach WEBSHOP zuerst, dann Name.
Pipeline-Checks (Impressum/Kanal/PLZ) werden aus dem notes-Feld geparst, falls vorhanden.

Usage:
  python3 tools/pending_review.py --restaurants data/regions/hannover/restaurants.json \
      --out data/regions/hannover/pending-review.md
"""

import argparse
import json
import re
import sys


def parse_notes(notes):
    """Extrahiert (osmId, checks, reasons) aus dem notes-String der Pipeline."""
    osm, checks, reasons = None, {}, []
    if not notes:
        return osm, checks, reasons
    m = re.search(r"pipeline (\S+?);", notes)
    if m:
        osm = m.group(1)
    m = re.search(r"checks=(\{.*?\}); reasons=", notes)
    if m:
        try:
            checks = json.loads(m.group(1))
        except ValueError:
            pass
    m = re.search(r"reasons=(\[.*?\])(?: \||$)", notes)
    if m:
        try:
            reasons = json.loads(m.group(1))
        except ValueError:
            pass
    return osm, checks, reasons


def yn(b) -> str:
    return "ja" if b else "nein"


def main() -> int:
    ap = argparse.ArgumentParser(description="Checkliste aller pending_review-Eintraege")
    ap.add_argument("--restaurants", required=True)
    ap.add_argument("--out", default=None, help="optionale Markdown-Ausgabe (sonst stdout)")
    args = ap.parse_args()

    with open(args.restaurants, encoding="utf-8") as f:
        data = json.load(f)
    region_id = data.get("regionId", "?")
    pending = [r for r in data.get("restaurants", []) if r.get("status") != "verified"]
    pending.sort(key=lambda r: (0 if "WEBSHOP" in r.get("orderTypes", []) else 1, r.get("name", "").lower()))

    lines = [
        f"# Pending Review {region_id} ({len(pending)} Eintraege, WEBSHOP zuerst, dann Name)",
        "",
        "Badge \"Verifizierung offen\" verschwindet in der App, wenn im Eintrag gesetzt: `\"status\": \"verified\"` + `\"lastVerified\": \"<heute>\"`.",
        "QS pro Eintrag: 1) PLZ in `postcodes` der Region, 2) Impressum + eigener Kanal (kein Plattform-Redirect), "
        "3) Kueche: stated uebernehmen, sonst Speisen analysieren -> `cuisineSource: \"derived\"` + Vermerk in notes, "
        "4) delivers/pickup nur mit Nachweis, 5) status=verified + lastVerified.",
        "Danach: `python tools\\validate_data.py` -> Assets spiegeln -> commit/push. Liste danach neu erzeugen (Snapshot).",
        "",
        "| [ ] | Name | PLZ | Kueche | Kanal | Lief./Abh. | Website | Tel | Pipeline: Impres./Kanal/PLZ | Reasons |",
        "|-----|------|-----|-------|-------|-----------|---------|-----|---------------------------|---------|",
    ]
    for r in pending:
        addr = r.get("address") or {}
        plz = addr.get("postcode") or "-"
        cuisines = ",".join(r.get("cuisines", []))
        src = r.get("cuisineSource") or "-"
        if src != "-":
            cuisines += f" ({src})"
        kanal = ",".join(r.get("orderTypes", [])) or "-"
        lief_abh = f"{'L' if r.get('delivers') else '-'}/{'A' if r.get('pickup') else '-'}"
        web = r.get("website") or "-"
        tel = r.get("phone") or "-"
        _, checks, reasons = parse_notes(r.get("notes"))
        pipe = f"Impressum:{yn(checks.get('imprintFound'))} Kanal:{yn(checks.get('hasOrderChannel'))} PLZ:{yn(checks.get('inRegionPostcode'))}"
        rsn = "; ".join(reasons)[:60] or "-"
        name = r.get("name", "?").replace("|", "\\|")
        web = web.replace("|", "\\|")
        lines.append(f"| [ ] | {name} | {plz} | {cuisines} | {kanal} | {lief_abh} | {web} | {tel} | {pipe} | {rsn} |")

    out = "\n".join(lines) + "\n"
    if args.out:
        with open(args.out, "w", encoding="utf-8") as f:
            f.write(out)
        print(f"geschrieben: {args.out} ({len(pending)} Eintraege)")
    else:
        print(out)
    return 0


if __name__ == "__main__":
    sys.exit(main())
