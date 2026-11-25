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

### Re-Run (neue Kandidaten holen) — Windows PowerShell

```powershell
cd C:\Users\braun\LewisApp\p2p_Fooddelivery
git pull
python -m pip install -r tools\requirements.txt

# alte Queue sichern (Ausschlussliste), Pipeline erneut laufen
# (Cache candidates.json.cache.json wird wiederverwendet -> bekannte Domains werden nicht erneut analysiert)
Copy-Item data\regions\hannover\review-queue.md data\regions\hannover\review-queue-old.md
python tools\research_pipeline.py --region data\regions\hannover\region.json --out data\regions\hannover\candidates.json --max 0 --delay 1.0

# Queue mit nur NEUEN Faellen (bekannte Domains aus restaurants.json + alte Queue ausschliessen)
python tools\review_queue.py --candidates data\regions\hannover\candidates.json --restaurants data\regions\hannover\restaurants.json --exclude-queue data\regions\hannover\review-queue-old.md --out data\regions\hannover\review-queue.md

# Plattform-Eintraege entfernen (Startseite verlinkt auf Lieferando & Co. oder wird von Plattform verwaltet;
# erstes --dry-run zeigt die Liste, ohne --dry-run wird entfernt + Assets gespiegelt):
python tools\qs_apply_analysis.py --restaurants data\regions\hannover\restaurants.json --candidates data\regions\hannover\candidates.json --dry-run
python tools\qs_apply_analysis.py --restaurants data\regions\hannover\restaurants.json --candidates data\regions\hannover\candidates.json

# mergen — NUR die neue Queue; --auto-verify markiert eindeutige auto_accept-Faelle
# (eigener Webshop + Impressum + PLZ in Region + Kueche stated) direkt als verified:
python tools\merge_candidates.py --candidates data\regions\hannover\candidates.json --out data\regions\hannover\restaurants.json --region data\regions\hannover\region.json --only-queue data\regions\hannover\review-queue.md --auto-verify
# danach manuell nur noch die uebrigen pending_review-Eintraege reviewen (QS-Checkliste im Queue-Header):
#   Uebersicht: review-queue.md (Tabelle mit Website-Spalte)  |  Edit: restaurants.json, nach "pending_review" suchen
#   Tipp: git diff nach dem Merge zeigt genau die neuen Eintraege
python tools\validate_data.py
Copy-Item data\regions\hannover\restaurants.json app\src\main\assets\regions\hannover\restaurants.json
git add -A
git commit -m "Pipeline-Re-Run Hannover: neue Kandidaten reviewed/merged"
git push
```

Wichtig: Beim Merge `--only-queue` mit der NEUEN Queue verwenden, sonst landen bereits abgelehnte Kandidaten erneut als `pending_review` im Datensatz. Ohne `--only-queue` waeren beim letzten Stand z. B. 101 alte Rejects wieder dazugekommen.

## Bestand verifizieren (Badge "Verifizierung offen" entfernen)

Aktuell 585 von 608 Eintraegen in Hannover sind `pending_review` (Badge in der App). Checkliste erzeugen:

```powershell
python tools\pending_review.py --restaurants data\regions\hannover\restaurants.json --candidates data\regions\hannover\candidates.json --out data\regions\hannover\pending-review.md
```

Die Spalte **QS-Flags** markiert Zweifelsfaelle gegen die aktuellen Regeln (WEBSHOP? = Pipeline sieht nur Telefon, PICKUP? = kein takeaway/abhol-Nachweis, LIEFERT? = kein Liefer-Nachweis) — manuell pruefen, korrigieren oder loeschen.

- `data\regions\hannover\pending-review.md` oeffnen (in Android Studio/VS Code): abhakbare Tabelle, WEBSHOP-Eintraege zuerst, inkl. Website/Tel und den Pipeline-Flags (Impressum/Kanal/PLZ aus den notes).
- Pro Eintrag Website aufrufen und die QS-Checkliste abarbeiten (steht im Header der Liste; Details in `docs/RESEARCH-PIPELINE.md` "Manuelle Verifizierung"): PLZ in Region, Impressum + eigener Kanal, Kueche (stated uebernehmen / sonst ableiten mit `cuisineSource: "derived"` + notes-Vermerk), delivers/pickup nur mit Nachweis.
- In `restaurants.json` pro geprueftem Eintrag setzen: `"status": "verified"`, `"lastVerified": "<heute>"` (Badge verschwindet bei `status == verified`, siehe `RestaurantListScreen.kt`). Ablehnen = Eintrag loeschen.
- Danach: `python tools\validate_data.py` (ALL DATA OK), `Copy-Item data\regions\hannover\restaurants.json app\src\main\assets\regions\hannover\restaurants.json`, commit + push. Checkliste bei Bedarf neu erzeugen (Snapshot).

## Neue Region

1. `data/regions/<stadt>/region.json` anlegen (bbox oder osmAreaName, `postcodes` = explizite PLZ-Liste, Blocklist).
2. Pipeline laufen lassen, Kandidaten manuell pruefen, `restaurants.json` befuellen.
3. Beides nach `app/src/main/assets/regions/<stadt>/` kopieren und `<stadt>` in `app/src/main/assets/regions/index.json` eintragen.
