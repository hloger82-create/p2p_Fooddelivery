#!/usr/bin/env python3
"""Validiert Regions-/Restaurant-Daten gegen die JSON-Schemas und parst alle JSON-Dateien.

Usage: python3 tools/validate_data.py   (im Repo-Root ausfuehren)
"""

import glob
import json
import sys

import jsonschema


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

    for path in sorted(glob.glob("app/src/main/assets/**/*.json", recursive=True)):
        with open(path, encoding="utf-8") as f:
            json.load(f)
        print(f"OK  {path}")

    print("ALL DATA OK")
    return 0


if __name__ == "__main__":
    sys.exit(main())
