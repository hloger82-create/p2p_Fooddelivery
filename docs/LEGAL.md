# Rechtssichere Umsetzung — Checkliste

Stand: zur Vorbereitung der Android-App (v1, Region Hannover). Kein Rechtsrat; vor Release anwaltlich pruefen lassen.

## 1. Geschaeftsmodell: reiner Link-Vermittler

- Die App verkauft nichts, nimmt keine Bestellungen an, erhaelt kein Geld bei Bestellungen.
- „Zum Restaurant" oeffnet die **eigene** Bestellseite/Website des Restaurants im Standardbrowser (`Intent.ACTION_VIEW`).
- consequence: kein Fernabsatzvertrag zwischen App-Betreiber und Nutzer; Widerrufsbelehrung, Vertragsschluss etc. liegen beim Restaurant.
- Haftungsausschluss in der App sichtbar platzieren (siehe `docs/templates/` und About-Screen): „Preise, Verfuegbarkeit, Liefergebiete und Bestellungen richten sich ausschliesslich nach dem jeweiligen Restaurant. Diese App uebernimmt keine Gewaehr.“

## 2. Urheberrecht: keine fremden Inhalte kopieren

- **Keine** Speisekarten, Fotos, Texte, Logos oder Preise von Restaurant-Websites in die App uebernehmen.
- Zulaessig: sachliche, oeffentliche Gewerbedaten (Name, Adresse, Telefon, Website, Oeffnungszeiten) und eigene, kurze Beschreibungen.
- Beim Self-Service-Eintrag: Nutzungsbedingungen, dass nur eigene Inhalte / rechtmaessig lizenzierte Bilder hochgeladen werden duerfen.

## 3. OpenStreetMap

- Kartenmaterial und POI-Daten unter **ODbL**. Pflicht: Namensnennung „© OpenStreetMap-Mitwirkende“ mit Link zu `https://www.openstreetmap.org/copyright` (im About-Screen der App umgesetzt).
- Tile-Server-Policy beachten: moderate Nutzung, kein Massen-Download; eigener User-Agent mit Kontakt bei API-Abfragen.
- Wenn das Restaurant-Dataset OSM-Daten enthaelt: Dataset ebenfalls unter ODbL oder mit entsprechender Quellenangabe veroeffentlichen.

## 4. Recherche / Crawling (siehe `tools/research_pipeline.py`)

- **Verboten**: Scraping von Google Maps, Lieferando, Wolt, Uber Eats, Volt u. a. (AGB-Verstoss, wettbewerbsrechtlich riskant). Plattform-Seiten werden nicht ausgelesen, nur als Redirect-Ziel erkannt.
- Zulaessig: OSM/Overpass/Nominatim (mit Rate-Limit und User-Agent) und die **eigenen oeffentlichen Websites** der Restaurants (robots.txt respektieren, max. 1 req/s pro Domain, keine Login-Bereiche, keine personenbezogenen Daten speichern).

## 5. App-Pflichten (DDG / DSGVO)

- Impressum in der App verlinkt/angezeigt (§ 5 DDG, seit 14.05.2024; davor § 5 TMG) — Template: `docs/templates/IMPRESSUM.md`.
- Datenschutzerklaerung (DSGVO Art. 13) — Template: `docs/templates/DATENSCHUTZ.md`.
- Grundsatz Datenminimierung: **kein Tracking, keine Werbe-IDs, keine Standort-Uebermittlung** in v1. Standort/PLZ des Nutzers wird nur lokal auf dem Geraet verarbeitet (Filter „liefert zu mir“), nie hochgeladen.
- Sobald Werbung/Analytics ins Spiel kommen: Einwilligung (Consent) einholen (TDDDG § 6, DSGVO Art. 6/7) — siehe `docs/MONETIZATION.md`.

## 6. Self-Service-Eintrag (ab v2) mit Verifizierung

Checkliste pro Eintrag (automatisierbar + manuell):
1. Impressum mit Pflichtangaben auf der Homepage vorhanden.
2. Adresse liegt innerhalb des Regions-Polygons (Geocoding gegen region.json).
3. Bestellkanal auf **eigener Domain**, Redirect-Check gegen `platformBlocklist` negativ.
4. Telefon erreichbar / Formular testweise ausfuellbar (manuell).
Eintrag erst nach bestandener Pruefung auf `verified` setzen; `lastVerified` pflegen.

Formular-Daten: nur was zur Verifizierung noetig ist; Zweckbindung, Loeschfrist, AVV mit Hosting-Anbieter, TLS. Nur Gewerbedaten speichern — **keine Privatpersonennamen** aus Impressen.

## 7. Werbung / Monetarisierung (Kennzeichnung)

- Kommerzielle Inhalte (Featured Listings, Werbeanzeigen) muessen klar als solche erkennbar sein (§ 6 TDDDG, UWG § 5a — keine Irrefuehrung).
- Bezahlte Eintraege duerfen die organische Sortierung nicht heimlich verzerren.

## 8. Aenderungen am Datensatz

- Dataset versioniert in Git; jede Aenderung per Commit nachvollziehbar.
- „Zuletzt geprueft am“ pro Eintrag; Meldefunktion in der App fuer falsche/alte Daten.
