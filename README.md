# p2p_Fooddelivery

Android-App (v1: Region **Hannover**), die lokale Restaurants mit **eigener Lieferung oder Abholung** anzeigt — ohne die grossen Plattformen (Lieferando, Wolt, Uber Eats, Volt ...). Die App oeffnet nur die eigene Bestellseite des Restaurants im Standardbrowser („Zum Restaurant") und verkauft selbst nichts.

## Funktionen (v1)

- Listen- und Kartenansicht (OpenStreetMap via OSMdroid, mit ODbL-Namensnennung)
- Filter: Kueche (Pizza, Doener, Asiatisch, Sushi, ...) und Bestellmoeglichkeit (Online-Shop, Formular, Telefon, Abholung) sowie „Liefert"
- Detailseite mit Adresse, Telefon (tap-to-call), Liefergebiet, „Zum Restaurant"-Button (öffnet externen Link)
- Regionsbasiert: neue Stadt = neue Config + neues Dataset, kein Code-Eingriff

## Repo-Layout

```
data/
  schema/                 JSON-Schema fuer Region + Restaurant-Dataset
  regions/hannover/       region.json (BBox, PLZ-Praefixe, Plattform-Blocklist) + restaurants.json (Seed)
docs/
  LEGAL.md                Checkliste rechtssichere Umsetzung
  MONETIZATION.md         gepruefte Monetarisierungsoptionen
  RESEARCH-PIPELINE.md    Doku der Recherche-Automation
  templates/              Impressum- und Datenschutz-Templates
tools/
  research_pipeline.py    Overpass + Website-Analyse (Redirect/Blocklist, Impressum, JSON-LD) -> candidates.json
app/                      Android-App (Kotlin, Jetpack Compose, Room, OSMdroid)
  src/main/assets/regions/  Kopie der Regionsdaten, die die App ausliefert
```

## Recherche-Pipeline (Datenbeschaffung)

```bash
pip install -r tools/requirements.txt
python3 tools/research_pipeline.py \
  --region data/regions/hannover/region.json \
  --out data/regions/hannover/candidates.json \
  --max 60 --delay 1.0
```

Ergebnis: `auto_accept` / `review` / `reject` pro Kandidat mit Begruendung. Manuell gepruefte Eintraege uebernehmen:

```bash
# data/regions/hannover/restaurants.json bearbeiten, dann in die App kopieren:
cp data/regions/hannover/restaurants.json app/src/main/assets/regions/hannover/restaurants.json
```

Rechtlicher Rahmen der Pipeline (robots.txt, Rate-Limit, keine Plattform-Inhalte, keine personenbezogenen Daten): siehe `docs/LEGAL.md` und `tools/README.md`.

## App bauen

Voraussetzung: Android Studio / JDK 17.

```bash
./gradlew :app:assembleDebug
```

Hinweis: Das Gradle-Wrapper-Jar ist nicht eingecheckt. Einmalig lokal erzeugen mit `gradle wrapper` (in Android Studio: Gradle-Task `wrapper` ausfuehren) — danach steht `./gradlew` zur Verfuegung. CI nutzt `gradle/actions/setup-gradle` und kommt ohne Wrapper aus.

## CI

`.github/workflows/ci.yml` laeuft bei Push/PR auf `main` und `vibe/**`:

- `pipeline-and-data-check`: Syntax-Check der Pipeline (`py_compile`) + Validierung aller Regions-/Restaurant-Daten gegen die JSON-Schemas (`tools/validate_data.py`)
- `android-build`: JDK 17 + Android SDK, `gradle :app:assembleDebug`, APK als Build-Artefakt

## Neue Region hinzufuegen

1. `data/regions/<stadt>/region.json` anlegen (bbox oder osmAreaName, postcodePrefixes, platformBlocklist).
2. Pipeline laufen lassen (`--region data/regions/<stadt>/region.json`), Kandidaten pruefen, `restaurants.json` befuellen.
3. Beides nach `app/src/main/assets/regions/<stadt>/` kopieren und `<stadt>` in `app/src/main/assets/regions/index.json` eintragen.

## Rechtliches & Finanzierung

- `docs/LEGAL.md`: Checkliste (Link-Vermittler, kein Kopieren fremder Inhalte, OSM/ODbL, DSGVO/TDDDG, Verifizierung von Self-Service-Eintraegen).
- `docs/MONETIZATION.md`: Featured Listings + Spenden empfohlen; lokale kontextuelle Werbung nur mit Consent (CMP); kein Tracking/Profiling.
- Templates fuer Impressum/Datenschutz: `docs/templates/`.

## Lizenz-Hinweis

Restaurant-Datensatz enthaelt OSM-abgeleitete Daten -> bei Veroeffentlichung ODbL-Quellenangabe („© OpenStreetMap-Mitwirkende“) beibehalten.
