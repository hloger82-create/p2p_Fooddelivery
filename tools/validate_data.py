#!/usr/bin/env python3
"""Validiert Regions-/Restaurant-Daten gegen die JSON-Schemas und parst alle JSON-Dateien.

Usage: python3 tools/validate_data.py   (im Repo-Root ausfuehren)
"""

import glob
import json
import sys
from urllib.parse import urlparse

import jsonschema


def host_of(url: str) -> str:
    return urlparse(url).netloc.lower().removeprefix("www.")


def main() -> int:
    with open("data/schema/region.schema.json", encoding="utf-8") as f:
        region_schema = json.load(f)
    with open("data/schema/restaurant.schema.json", encoding="utf-8") as f:
        restaurant_schema = json.load(f)

    for path in sorted(glob.glob("data/regions/*/region.json")):
        with open(path, encoding="utf-8") as f:
            jsonschema.validate(json.load(f), region_schema)
        print(f"OK  {path}")

    for path in sorted(glob.glob("data/regions/*/restaurants.json")):
        with open(path, encoding="utf-8") as f:
            jsonschema.validate(json.load(f), restaurant_schema)
        print(f"OK  {path}")

    # Cross-Checks: Region-PLZ (postcodes) + Assets-Mirror
    errors = []
    for region_path in sorted(glob.glob("data/regions/*/region.json")):
        region_dir = region_path.rsplit("/", 1)[0]
        with open(region_path, encoding="utf-8") as f:
            region = json.load(f)
        plz_list = set(region.get("postcodes", []))
        rest_path = f"{region_dir}/restaurants.json"
        with open(rest_path, encoding="utf-8") as f:
            dataset = json.load(f)
        if plz_list:
            for r in dataset.get("restaurants", []):
                plz = (r.get("address") or {}).get("postcode")
                if plz and plz not in plz_list:
                    errors.append(f"{rest_path}: {r.get('id')} hat PLZ {plz} (Stadt {(r.get('address') or {}).get('city')}), liegt nicht in postcodes von {region_path}")
        # App ist reines Link-Out: ohne Website ist ein Eintrag nicht zulaessig (QS-Regel)
        blocklist = set(region.get("platformBlocklist", []))
        for r in dataset.get("restaurants", []):
            web = r.get("website")
            if not web:
                errors.append(f"{rest_path}: {r.get('id')} hat keine website -> Ausschluss (Link-Out-App)")
            else:
                h = host_of(web)
                if any(h == b or h.endswith("." + b) for b in blocklist):
                    errors.append(f"{rest_path}: {r.get('id')} verlinkt auf Plattform-Domain {web} -> Ausschluss")
            # QS-Regel: weder Lieferung noch Abholung -> Telefon vermutlich nur Reservierung -> Ausschluss
            if not r.get("delivers") and not r.get("pickup"):
                errors.append(f"{rest_path}: {r.get('id')} bietet weder Lieferung noch Abholung -> Ausschluss")
        # Assets-Mirror: data/ und app/assets muessen identisch sein
        for name in ("region.json", "restaurants.json"):
            asset_path = f"app/src/main/assets/regions/{region['id']}/{name}"
            try:
                with open(asset_path, encoding="utf-8") as f:
                    asset = json.load(f)
            except FileNotFoundError:
                errors.append(f"fehlendes Asset: {asset_path}")
                continue
            with open(f"{region_dir}/{name}", encoding="utf-8") as f:
                src = json.load(f)
            if asset != src:
                errors.append(f"Asset nicht identisch mit data/: {asset_path} != {region_dir}/{name}")

    for path in sorted(glob.glob("app/src/main/assets/**/*.json", recursive=True)):
        with open(path, encoding="utf-8") as f:
            json.load(f)
        print(f"OK  {path}")

    if errors:
        for e in errors:
            print(f"ERROR  {e}", file=sys.stderr)
        print("DATA ERRORS", file=sys.stderr)
        return 1

    print("ALL DATA OK")
    return 0


if __name__ == "__main__":
    sys.exit(main())
