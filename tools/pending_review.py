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
from urllib.parse import urlparse


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
    ap.add_argument("--candidates", default=None, help="candidates.json der Pipeline ( fuer QS-Flags: WEBSHOP?/PICKUP?/LIEFERT? )")
    ap.add_argument("--out", default=None, help="optionale Markdown-Ausgabe (sonst stdout)")
    args = ap.parse_args()

    with open(args.restaurants, encoding="utf-8") as f:
        data = json.load(f)
    region_id = data.get("regionId", "?")
    pending = [r for r in data.get("restaurants", []) if r.get("status") != "verified"]
    pending.sort(key=lambda r: (0 if "WEBSHOP" in r.get("orderTypes", []) else 1, r.get("name", "").lower()))

    # candidates.json fuer QS-Flags (Match ueber osmId aus notes oder Website-Domain)
    by_osm, by_dom = {}, {}
    if args.candidates:
        with open(args.candidates, encoding="utf-8") as f:
            for c in json.load(f).get("candidates", []):
                if c.get("osmId"):
                    by_osm[c["osmId"]] = c
                w = c.get("website")
                if w:
                    by_dom[urlparse(w).netloc.lower().removeprefix("www.")] = c

    def cand_of(r):
        m = re.search(r"pipeline (\S+?);", r.get("notes") or "")
        if m and m.group(1) in by_osm:
            return by_osm[m.group(1)]
        w = r.get("website") or ""
        return by_dom.get(urlparse(w).netloc.lower().removeprefix("www."))

    def qs_flags(r) -> str:
        if not args.candidates:
            return "-"
        c = cand_of(r)
        flags = []
        tags = (c or {}).get("osmTags", {}) if c else {}
        oc = (c or {}).get("analysis", {}).get("orderChannel") if c else None
        notes = (r.get("notes") or "").lower()
        if "WEBSHOP" in r.get("orderTypes", []) and oc == "phone":
            flags.append("WEBSHOP?")
        if r.get("pickup") and not (
            tags.get("takeaway") in ("yes", "only")
            or "abhol" in notes or "mitnehm" in notes
            or ("WEBSHOP" in r.get("orderTypes", []) and not r.get("delivers"))
        ):
            flags.append("PICKUP?")
        if r.get("delivers") and not (
            tags.get("delivery") in ("yes", "only")
            or (c and c.get("analysis", {}).get("deliveryMentioned"))
            or "liefer" in notes
        ):
            flags.append("LIEFERT?")
        return ",".join(flags) or "-"

    lines = [
        f"# Pending Review {region_id} ({len(pending)} Eintraege, WEBSHOP zuerst, dann Name)",
        "",
        "Badge \"Verifizierung offen\" verschwindet in der App, wenn im Eintrag gesetzt: `\"status\": \"verified\"` + `\"lastVerified\": \"<heute>\"`.",
        "QS pro Eintrag: 1) PLZ in `postcodes` der Region, 2) Impressum + eigener Kanal (kein Plattform-Redirect), "
        "3) Kueche: stated uebernehmen, sonst Speisen analysieren -> `cuisineSource: \"derived\"` + Vermerk in notes, "
        "4) delivers/pickup nur mit Nachweis, 5) status=verified + lastVerified.",
        "Danach: `python tools\\validate_data.py` -> Assets spiegeln -> commit/push. Liste danach neu erzeugen (Snapshot).",
        "",
        "QS-Flags: WEBSHOP? = Pipeline sieht nur Telefon (kein Shop) | PICKUP? = kein takeaway/abhol-Nachweis | LIEFERT? = kein Liefer-Nachweis. Flags manuell pruefen!",
        "",
        "| [ ] | Name | PLZ | Kueche | Kanal | Lief./Abh. | Website | Tel | Pipeline: Impres./Kanal/PLZ | QS-Flags | Reasons |",
        "|-----|------|-----|-------|-------|-----------|---------|-----|---------------------------|----------|---------|",
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
        lines.append(f"| [ ] | {name} | {plz} | {cuisines} | {kanal} | {lief_abh} | {web} | {tel} | {pipe} | {qs_flags(r)} | {rsn} |")

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
