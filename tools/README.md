# Recherche-Pipeline

Automatisiert die Suche nach geeigneten Restaurant-Eintraegen fuer eine Region.

## Ablauf

1. **Overpass API**: alle `amenity=restaurant` / `fast_food` in der Region (BBox oder OSM-Area aus `region.json`).
2. **Geocoding** (Nominatim, 1 req/s) falls OSM keine Koordinaten hat.
3. **Website-Analyse** (nur die eigene Domain des Restaurants, `robots.txt` wird respektiert, Rate-Limit via `--delay`):
   - Redirect-Check aller Bestell-Links: landet die Kette auf einer Domain der `platformBlocklist` (Lieferando, Wolt, Uber Eats, Volt, ... sowie reine Aggregator-Portale wie pizza.de), wird der Kandidat als `reject` markiert.
   - Impressum-Check (Links auf /impressum etc., Pflichtangaben gemaess § 5 TMG).
   - Bestellkanal-Erkennung: eigener Webshop (WooCommerce/Shopify/simplywebshop/...), Bestellformular, oder nur Telefon.
   - Extraktion von Telefon, Oeffnungszeiten und Kueche aus JSON-LD (`schema.org/Restaurant`).
   - Liefergebiet: Keywords + PLZ mit Regions-Praefix.
4. **Scoring**: `auto_accept` (alle Checks bestanden), `review` (manuelle Pruefung noetig), `reject` (Plattform-Redirect / kein Kanal).

## Nutzung

```bash
pip install -r tools/requirements.txt
python3 tools/research_pipeline.py \
  --region data/regions/hannover/region.json \
  --out data/regions/hannover/candidates.json \
  --max 60 --delay 1.0
```

Nur OSM-Daten ohne Website-Analyse: `--skip-website-check`.

## Output

`candidates.json` enthaelt pro Kandidat OSM-Daten, Analyse-Ergebnis, Checks, Begruendungen und Status. Daraus werden manuell gepruefte Eintraege in `data/regions/<region>/restaurants.json` uebernommen (und in die App-Assets kopiert).

## Rechtlicher Rahmen

- Nur oeffentlich zugaengliche Seiten der Restaurants selbst; keine Login-Bereiche.
- `robots.txt` wird respektiert; Requests werden gebremst; eigener User-Agent mit Kontakt.
- Plattform-Seiten (Lieferando etc.) werden **nicht** ausgelesen, sondern nur als Redirect-Ziel erkannt.
- Keine personenbezogenen Daten; nur oeffentliche Gewerbedaten (Firma, Adresse, Telefon, Website).
- Vor Veroeffentlichung immer manuelle Endpruefung (siehe `docs/LEGAL.md`).

## Neue Region

1. `data/regions/<stadt>/region.json` anlegen (bbox oder osmAreaName, PLZ-Praefixe, Blocklist).
2. Pipeline laufen lassen, Kandidaten manuell pruefen, `restaurants.json` befuellen.
3. Beides nach `app/src/main/assets/regions/<stadt>/` kopieren und `<stadt>` in `app/src/main/assets/regions/index.json` eintragen.
