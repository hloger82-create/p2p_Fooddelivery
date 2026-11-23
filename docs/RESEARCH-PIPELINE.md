# Recherche-Pipeline — Doku

Details und Nutzung siehe `tools/README.md`. Kurzfassung:

```bash
pip install -r tools/requirements.txt
python3 tools/research_pipeline.py --region data/regions/hannover/region.json \
    --out data/regions/hannover/candidates.json --max 60 --delay 1.0
```

## Stufen

1. Overpass: `amenity=restaurant|fast_food` in der Region (BBox/OSM-Area aus `region.json`).
2. Nominatim-Geocoding fuer fehlende Koordinaten (1 req/s).
3. Website-Analyse der **eigenen Restaurant-Domain** (robots.txt, Rate-Limit, eigener UA):
   - Redirect-Check der Bestell-Links gegen `platformBlocklist` -> Plattform-only = `reject`.
   - Impressum-Check (§ 5 TMG Pflichtangaben).
   - Bestellkanal: eigener Webshop / Formular / Telefon (JSON-LD + Keyword-Heuristik).
   - Telefon, Oeffnungszeiten, Kueche aus JSON-LD; Liefergebiet via Keywords + PLZ-Praefix.
4. Scoring: `auto_accept` / `review` / `reject` mit Begruendungen -> `candidates.json`.

## Uebernahme in den Datensatz

Automatisiert via Merge-Tool (uebernimmt Kandidaten inkl. Koordinaten/Bestellarten/Liefer-PLZ, Duplikate werden per Website-Domain erkannt, Status bleibt `pending_review` bis zur manuellen Endpruefung):

```bash
python3 tools/merge_candidates.py \
  --candidates data/regions/hannover/candidates.json \
  --out data/regions/hannover/restaurants.json \
  --region data/regions/hannover/region.json
python3 tools/validate_data.py
cp data/regions/hannover/restaurants.json app/src/main/assets/regions/hannover/restaurants.json
```

Schema: `data/schema/restaurant.schema.json`. App-Assets aktualisieren nicht vergessen — alternativ greift die App zur Laufzeit auf `datasetUrl` (raw.githubusercontent .../main/...) zu.

## Rechtlicher Rahmen

Nur oeffentliche Seiten; robots.txt; Rate-Limit; keine Plattform-Inhalte; keine personenbezogenen Daten. Siehe `docs/LEGAL.md` Abschnitt 4.
