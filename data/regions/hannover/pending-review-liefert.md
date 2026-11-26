# Pending Review hannover (20 Eintraege, Flag LIEFERT?, WEBSHOP zuerst, dann Name) | Flags gesamt: LIEFERT?=20, PICKUP?=206, WEBSHOP?=8

Badge "Verifizierung offen" verschwindet in der App, wenn im Eintrag gesetzt: `"status": "verified"` + `"lastVerified": "<heute>"`.
QS pro Eintrag: 1) PLZ in `postcodes` der Region, 2) Impressum + eigener Kanal (kein Plattform-Redirect), 3) Kueche: stated uebernehmen, sonst Speisen analysieren -> `cuisineSource: "derived"` + Vermerk in notes, 4) delivers/pickup nur mit Nachweis, 5) status=verified + lastVerified.
Danach: `python tools\validate_data.py` -> Assets spiegeln -> commit/push. Liste danach neu erzeugen (Snapshot). Mit --flag 'PICKUP?' z. B. nur die PICKUP-Zweifelsfaelle listen.

QS-Flags: WEBSHOP? = Pipeline sieht nur Telefon (kein Shop) | PICKUP? = kein takeaway/abhol-Nachweis | LIEFERT? = kein Liefer-Nachweis. Flags manuell pruefen!

| [ ] | ID | Name | PLZ | Kueche | Kanal | Lief./Abh. | Website | Tel | Pipeline: Impres./Kanal/PLZ | QS-Flags | Reasons |
|-----|------|----|-----|-------|-------|-----------|---------|-----|---------------------------|----------|---------|
| [ ] | hannover-ecrin-doener | Ecrin Döner (Bülbül Grill) | 30457 | DOENER (stated) | WEBSHOP,PHONE | L/A | https://buelbuel-grill.9gg.de | +49 179 2031621 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-fisch-muller | Fisch Müller | - | OTHER (stated) | WEBSHOP,PHONE | L/A | https://fisch-mueller.eatbu.com/ | +49 170 5794341 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-fischerhof-pizza-doner | Fischerhof Pizza & Döner | - | PIZZA,DOENER (stated) | WEBSHOP | L/- | https://fischerhof-pizza-doener.eatbu.com/?lang=de | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-hansa-croque | Hansa Croque | 30627 | BURGER | WEBSHOP,PHONE | L/A | https://hansa-croque-hannover.de/ | +49 05115198585 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-honeys-linden | Honey's Linden | 30451 | BURGER (stated) | WEBSHOP,PHONE | L/A | https://honeys-hannover.de/ | +49 511 94051082 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-kebap-63 | Kebap 63 | - | DOENER,TURKISH | WEBSHOP,PHONE | L/A | https://www.kebap63-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-la-castagna | La Castagna | 30629 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | L/A | https://la-castagna.metro.rest/ | +49 511 581515 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-lavash-back-doner | Lavash Back & Döner | 30167 | DOENER,TURKISH (stated) | WEBSHOP,PHONE | L/A | https://lavash-hannover.doener-curator.com/de/ | +49 511 64690753 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-lister-laube | Lister Laube | 30179 | OTHER (stated) | WEBSHOP,PHONE | L/A | https://www.listerlaube.de/ | +49 511 371636 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-mamma-enzo | Mamma Enzo (List) | 30161 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://mamma-enzo.de/ | +49 511 47574748 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-pizza-grande | Pizza Grande | 30159 | PIZZA (stated) | WEBSHOP,PHONE | L/A | https://pizza-grande.net/ | +49 511 16921200 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-street-kitchen | Street Kitchen - Viet Cuisine | 30451 | VIETNAMESE | WEBSHOP,PHONE | L/A | https://streetkitchen-viet-cuisine-hannover.de/ | +49 511 98638834 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-sultan-kebap | Sultan Kebap Hannover | - | DOENER,TURKISH,PIZZA,BURGER | WEBSHOP,PHONE | L/- | https://www.sultankebaphannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-thessaloniki | Thessaloniki | 30165 | GREEK (stated) | WEBSHOP,PHONE | L/A | https://thessaloniki-hanover.edan.io | +49 05113506461 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-trattoria-ecco | Trattoria Ecco | 30171 | ITALIAN (stated) | WEBSHOP,PHONE | L/A | https://trattoria-ecco.eatbu.com/ | +49 511 70819235 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-oz-urfa-63 | ÖZ URFA 63 | - | DOENER,TURKISH (stated) | WEBSHOP | L/- | https://soez-urfa-63.eatbu.com/ | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-buddha-bowl | Buddha Bowl | 30159 | ASIAN,OTHER (stated) | PHONE | L/A | https://buddha-bowl-hannover.menueat.net/ | +49 511 22863444 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | hannover-piri-piri | Piri Piri | 30451 | PIZZA,GRILL (stated) | PHONE | L/- | https://piripirihannover.de/ | +49 152 11351188 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-pizza-freund | Pizza Freund | 30179 | PIZZA,ITALIAN (stated) | PHONE | L/- | https://www.pizzafreundhannover.de/ | +49 511 666555 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | hannover-vino-kebab | vino kebab | 30459 | DOENER,PIZZA,TURKISH (stated) | PHONE,PICKUP | L/A | https://restaurant-zaza.de/ | +49 511 64710665 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
