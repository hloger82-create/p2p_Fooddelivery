# Recherche-Pipeline

Automatisiert die Suche nach geeigneten Restaurant-Eintraegen fuer eine Region.

## Ablauf

1. **Overpass API**: alle `amenity=restaurant` / `fast_food` in der Region (BBox oder OSM-Area aus `region.json`).
2. **Geocoding** (Nominatim, 1 req/s) falls OSM keine Koordinaten hat.
3. **Website-Analyse** (nur die eigene Domain des Restaurants, `robots.txt` wird respektiert, Rate-Limit via `--delay`):
   - Redirect-Check aller Bestell-Links: landet die Kette auf einer Domain der `platformBlocklist` (Lieferando, Wolt, Uber Eats, Volt, ... sowie reine Aggregator-Portale wie pizza.de), wird der Kandidat als `reject` markiert.
   - Impressum-Check (Links auf /impressum etc., Pflichtangaben gemaess § 5 TMG).
   - Bestellkanal-Erkennung: eigener Webshop (WooCommerce/Shopify/simplywebshop/...) oder nur Telefon. (Reine Kontakt-/Reservierungsformulare zaehlen nicht als Bestellkanal.)
   - Extraktion von Telefon, Oeffnungszeiten und Kueche aus JSON-LD (`schema.org/Restaurant`).
   - Liefergebiet: Keywords + PLZ aus der Regionsliste (`postcodes`).
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

Falls die Overpass-Hauptinstanz (overpass-api.de) mit 502/504/429 antwortet: anderes Endpunkt mitgeben, z. B.
`--overpass https://overpass.osm.ch/api/interpreter` — ohne Angabe werden die Fallback-Instanzen
(kumi.systems, private.coffee, overpass.openstreetmap.fr, overpass.osm.ch) automatisch durchprobiert,
bei 429 mit Retry-After-Backoff (bis 120s). Tipp: bei dauerhaftem 429 kurz warten und `--max 30` verwenden.

## Output

`candidates.json` enthaelt pro Kandidat OSM-Daten, Analyse-Ergebnis, Checks, Begruendungen und Status (`auto_accept` / `review` / `reject`).

## Merge in den Datensatz

```bash
python3 tools/merge_candidates.py \
  --candidates data/regions/hannover/candidates.json \
  --out data/regions/hannover/restaurants.json \
  --region data/regions/hannover/region.json
python3 tools/validate_data.py
cp data/regions/hannover/restaurants.json app/src/main/assets/regions/hannover/restaurants.json
```

Das Merge-Tool uebernimmt alle Kandidaten (ausser `reject` / ohne Website), inkl. Koordinaten, Bestellarten, Telefon, Liefer-PLZ. Status bleibt `pending_review` — manuelle Endpruefung (Impressum, Region, eigener Kanal) vor dem Umstellen auf `verified` nicht vergessen (siehe `docs/LEGAL.md`). Duplikate werden anhand der Website-Domain erkannt.

## Rechtlicher Rahmen

- Nur oeffentlich zugaengliche Seiten der Restaurants selbst; keine Login-Bereiche.
- `robots.txt` wird respektiert; Requests werden gebremst; eigener User-Agent mit Kontakt.
- Plattform-Seiten (Lieferando etc.) werden **nicht** ausgelesen, sondern nur als Redirect-Ziel erkannt.
- Keine personenbezogenen Daten; nur oeffentliche Gewerbedaten (Firma, Adresse, Telefon, Website).
- Vor Veroeffentlichung immer manuelle Endpruefung (siehe `docs/LEGAL.md`).

## Review-Queue + manuelle Verifizierung (QS)

```bash
python3 tools/review_queue.py --candidates data/regions/hannover/candidates.json \
    --out data/regions/hannover/review-queue.md
```

Sortiert die `review`-Kandidaten nach Score (delivery/takeaway-Tags, eigener Webshop, Impressum, Koordinaten) — Top of the list zuerst manuell pruefen und in `restaurants.json` auf `verified` setzen oder loeschen.

QS-Checkliste pro Fall (siehe auch `docs/RESEARCH-PIPELINE.md` Abschnitt "Manuelle Verifizierung"):
1. PLZ in der Regionsliste (`postcodes`) + BBox, 2. Impressum + eigener Kanal (kein Plattform-Redirect),
3. **Kueche**: `cuisineSource=stated` uebernehmen; nicht angegeben -> Speisen analysieren, eigene Schlussfolgerung (`cuisineSource=derived` + Vermerk in `notes`),
4. delivers/pickup nur mit Nachweis, 5. `status=verified` + `lastVerified` setzen.

## Neue Region

1. `data/regions/<stadt>/region.json` anlegen (bbox oder osmAreaName, `postcodes` = explizite PLZ-Liste, Blocklist).
2. Pipeline laufen lassen, Kandidaten manuell pruefen, `restaurants.json` befuellen.
3. Beides nach `app/src/main/assets/regions/<stadt>/` kopieren und `<stadt>` in `app/src/main/assets/regions/index.json` eintragen.
