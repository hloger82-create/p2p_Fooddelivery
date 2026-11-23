# Monetarisierung — Optionen geprueft

Ziel: unabhaengig bleiben (keine Plattform-Provisionen, kein Tracking-Geschaeftsmodell), aber tragfaehig. Reihenfolge ist eine Empfehlung.

## 1. Featured Listings (empfohlen zum Start)

- Restaurants zahlen einen kleinen, transparent kommunizierten Jahresbeitrag (z. B. 99–199 EUR/Jahr) fuer einen hervorgehobenen Eintrag.
- **Rechtlich**: B2B, DSGVO-unproblematisch. Muss klar als „Featured“/„Anzeige“ gekennzeichnet sein (§ 6 TDDDG, UWG § 5a) und darf die organische Sortierung nicht heimlich verzerren.
- **Passgenau**: Restaurants sparen gegenueber Plattformen 15–30 % Provision pro Bestellung — der Beitrag ist im Vergleich sehr guenstig.

## 2. Spenden / „App unterstuetzen“

- Freiwillige Unterstuetzung via In-App-Kauf (Google Play Billing) oder Stripe.
- **Rechtlich**: DSGVO-einfach (Zahlungsdaten beim Zahlungsanbieter, AVV noetig). Keine Gegenleistung -> keine Werbe-Kennzeichnung noetig, aber Transparenz im About-Screen („finanziert sich ueber …“).

## 3. Lokale, kontextuelle Werbung (Phase 2)

- Dezent integrierte Anzeigen lokaler Anbieter (z. B. im Listenbereich), **kontextuell** (kein Profiling).
- **Rechtlich in DE/EU**: DSGVO + TDDDG (§ 6, ehem. § 25 TTDSG). Jedes Werbe-SDK greift auf den Geraetespeicher zu -> **Consent-Pflicht**, auch fuer „non-personalized ads“ (AdMob NPA). Umsetzung: Consent Management Platform (z. B. Usercentrics/Sourcepoint oder OSS-Alternative), Default „nur notwendige“, NPA-Modus. Kommerzielle Kommunikation muss als „Werbung“ gekennzeichnet sein (§ 6 TDDDG).
- Variante ohne Tracking und ohne Consent-Overhead: feste, direkt gebuchte Sponsored Placements lokaler Anbieter, klar als „Werbung“ gelabelt.
- **Hinweis**: personalisierte Werbung passt nicht zur Unabhaengigkeits-Marke und erhoeht den DSGVO-Aufwand deutlich.

## 4. B2B-Lizenz an Stadt / Tourismus / Wirtschaftfoerderung

- Aggregierte, **anonymisierte** Auswertungen lizenzieren (z. B. „X Restaurants mit eigener Lieferung in Hannover“, heatmapartige Daten ohne Einzeladressen, falls gewuenscht).
- **Rechtlich**: keine personenbezogenen Daten -> DSGVO-sicher.

## 5. Nicht empfohlen

- **Affiliate-Links** zu Restaurant-eigenen Shops: nur mit Consent + Transparenz, kollidiert mit dem Unabhaengigkeits-Image.
- **Personalisierte Werbung / Profiling / Verkauf von Nutzerdaten**: hoher DSGVO-Aufwand, Widerspruch zur Idee. Tabu.

## Empfehlung

Start: (1) Featured Listings + (2) Spenden. Phase 2: (3) kontextuelle lokale Werbung mit CMP. Optional spaeter: (4). Alle Einnahmen transparent im About-Screen ausweisen.
