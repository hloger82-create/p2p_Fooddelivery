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
   - Impressum-Check (§ 5 DDG Pflichtangaben).
   - Bestellkanal: eigener Webshop / Telefon (JSON-LD + Keyword-Heuristik). Kontakt-/Reservierungsformulare zaehlen nicht als Bestellformular.
   - Telefon, Oeffnungszeiten, Kueche aus JSON-LD; Liefergebiet via Keywords + PLZ aus der Regionsliste (`postcodes`).
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

## Manuelle Verifizierung (QS)

Jeder `pending_review`-Eintrag wird vor dem Umstellen auf `verified` manuell geprueft (Reihenfolge):

1. **Region**: `addr:postcode` in `postcodes` der Region, Adresse/Koordinaten im BBox. (In der Pipeline bereits als `inRegionPostcode`-Check mit `reject` vorgelagert; in der App weist ein Hinweis unter dem PLZ-Feld auf PLZ ausserhalb der Region hin.)
2. **Rechtlich/Kanal**: Impressum gefunden, eigener Bestellkanal (Webshop/Telefon), kein Plattform-Redirect.
3. **Kuechen-Pruefung**: Ist die Kueche auf OSM/Website angegeben (`cuisineSource: "stated"` aus der Pipeline), wird sie uebernommen. **Ist sie nicht angegeben**: Speisekarte bzw. angebotene Speisen analysieren und eine eigene Schlussfolgerung ziehen (z. B. Pizza/Pasta -> `PIZZA` + `ITALIAN`), dann `cuisines` entsprechend setzen, `cuisineSource: "derived"` und kurzer Vermerk in `notes` (z. B. "Kueche aus Speisekarte abgeleitet"). Kein blosses Raten. Die App kennzeichnet abgeleitete Kuechen mit einem kleinen Hinweis im Detail-Screen.
4. **Lieferung/Abholung nur mit Nachweis**: `delivers` nur bei expliziter Lieferangabe; `pickup` nur bei OSM `takeaway=yes/only`, expliziter Abholmption oder Telefon/eigener Shop ohne Lieferung.
5. `lastVerified` = Datum setzen, `status: "verified"`.

## QS-Backlog

- (leer — Kuechen-Pruefung ist oben im Verifizierungsprozess verankert)
