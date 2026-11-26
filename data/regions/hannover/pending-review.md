# Pending Review hannover (439 Eintraege, WEBSHOP zuerst, dann Name)

Badge "Verifizierung offen" verschwindet in der App, wenn im Eintrag gesetzt: `"status": "verified"` + `"lastVerified": "<heute>"`.
QS pro Eintrag: 1) PLZ in `postcodes` der Region, 2) Impressum + eigener Kanal (kein Plattform-Redirect), 3) Kueche: stated uebernehmen, sonst Speisen analysieren -> `cuisineSource: "derived"` + Vermerk in notes, 4) delivers/pickup nur mit Nachweis, 5) status=verified + lastVerified.
Danach: `python tools\validate_data.py` -> Assets spiegeln -> commit/push. Liste danach neu erzeugen (Snapshot).

QS-Flags: WEBSHOP? = Pipeline sieht nur Telefon (kein Shop) | PICKUP? = kein takeaway/abhol-Nachweis | LIEFERT? = kein Liefer-Nachweis. Flags manuell pruefen!

| [ ] | Name | PLZ | Kueche | Kanal | Lief./Abh. | Website | Tel | Pipeline: Impres./Kanal/PLZ | QS-Flags | Reasons |
|-----|------|-----|-------|-------|-----------|---------|-----|---------------------------|----------|---------|
| [ ] | 6 Sinne Riverside | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://6sinne-hannover.de/ | +49 511 99987452 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | 60 seconds to napoli | 30159 | PIZZA (stated) | WEBSHOP | -/A | https://60secondstonapoli.de/standort/hannover/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Agorino | 30625 | ITALIAN,PIZZA (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://agorino.de/ | +49 511 53335333 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Al-Dar | 30175 | OTHER (stated) | WEBSHOP | -/A | https://aldar.de/restaurant/hannover/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Alte Ricklinger Bierquelle | 30459 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://alte-ricklinger-bierquelle.de/ | +49 511 70034038 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ambrosia | 30655 | GREEK (stated) | WEBSHOP | -/A | https://ambrosia-restaurant.de | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Antalya Döner | 30629 | TURKISH,DOENER | WEBSHOP,PHONE | L/A | https://www.antalyadoener-hannover.de/ | +49 01735611627 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Aresto | 30159 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://www.aresto.de/ | +49 511 323759 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | AREZZO | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://ristorante-arezzo.eatbu.com | +49 511 72746930 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Asia Dao | 30451 | ASIAN,VIETNAMESE,THAI,SUSHI (stated) | WEBSHOP,PHONE | L/A | https://asia-dao.de/ | +49 511 53430929 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Asia Dr. Wok | 30159 | ASIAN,THAI,VIETNAMESE (stated) | WEBSHOP,PHONE | -/A | https://asia-dr-wok-hannover.jimdofree.com/ | +49 511 67518046 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Asia Gourmet | - | ASIAN (stated) | WEBSHOP | -/A | https://www.asiagourmet.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Asianativ | - | ASIAN (stated) | WEBSHOP,PHONE | -/A | https://www.asianativ.de/ | +49 511 59202936 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Atas Kebab House | 30165 | DOENER,GRILL,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://atas-kebab-house.eatbu.com | +49 511 54300378 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Badenstedter Döner | 30455 | DOENER (stated) | WEBSHOP,PHONE | -/A | https://badenstedter-doener.eatbu.com | +49 511 56967010 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | BAMBUS - Asia Bistro | - | ASIAN (stated) | WEBSHOP,PHONE | L/- | https://www.asiabambus.de/ | +49 511755422 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bar Añejo | 30451 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.bar-anejo.com | +4951149537241 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Baratie | 30173 | BURGER (stated) | WEBSHOP,PHONE | L/A | https://www.baratiehannover.de/ | +49 176 82157476 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Beckers | - | OTHER | WEBSHOP | -/A | https://www.beckers-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Beef and Reef | 30171 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.beefandreef.de/ | +49 511 54356738 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Bei Ranko | 30629 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | http://restaurant-ranko.de | +49 511 582357 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bestia Vera Pizza Napoletana | 30159 | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://www.bestia.pizza | +49 511 41088730 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bistro Emporio | 30453 | ITALIAN (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.rossini-gmbh.de/ | +49 511 423388 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bistro-Bringdienst da Toni | 30163 | PIZZA (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.bringdienst-da-toni.de/ | +49 511 967 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bodega Argentina | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://bodega-argentina.de/ | +49 1516 1487628 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Bosco | - | ITALIAN (stated) | WEBSHOP | -/A | https://ristorantebosco.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Brauhaus Ernst-August | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.brauhaus.net/ | +49 511 365950 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Broyhan Haus | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.broyhanhaus.de/ | +49 511 323919 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Brudis Döner & Burger | 30419 | BURGER,DOENER (stated) | WEBSHOP,PHONE | L/A | https://brudis-db.de | +49 051153558445 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Brunnenhof | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://restaurantbrunnenhof.de | +49 511 3683920 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Burger Hannover | 30171 | BURGER (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://burgerhannover.de | +49 511 35386300 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Burgermeister | 30451 | BURGER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://burgermeister.com/ | +49 511 12371790 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Castello | 30419 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.castello-hannover.de/ | +49 511 751289 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | cavallo - Königliche Reithalle | - | OTHER | WEBSHOP,PHONE | -/A | https://www.cavallo-reithalle.de | 05112889911 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | China-Restaurant Mo | 30457 | CHINESE (stated) | WEBSHOP,PHONE | -/A | https://www.chinarestaurantmo.de/ | +49 511 434370 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Chiuy Phat | 30161 | VIETNAMESE (stated) | WEBSHOP,PHONE | -/A | https://thuyphat.de/ | 051154534773 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Costas Greek Taverna | 30163 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://www.costas-taverne.de/ | +49 511 697103 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Curry Culum | 30159 | BURGER (stated) | WEBSHOP,PHONE | -/A | https://www.curryculum.de/ | +49 511 47399361 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Da Gennaro Trattoria | 30177 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://dagennaro.de/ | +49 511 39083833 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Da Lello | 30171 | ITALIAN (stated) | WEBSHOP,PICKUP,PHONE | L/A | http://ristorante.dalello.de/ | +49 511 32 07 05 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Das Zwiespalt | 30449 | OTHER (stated) | WEBSHOP,PHONE | L/A | https://daszwiespalt.de | +49 511 54397753 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | dean&david | 30161 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://deananddavid.com/lister-meile-hannover/ | +49 511 45011187 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | doydoy´s | 30175 | PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://shop.liefersoft.de/doydoys-pizza-30175-e0 | +4951121906834 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Döner King 1 | 30519 | DOENER (stated) | WEBSHOP,PHONE | -/A | https://www.donerkinghannover.de | +49 151 62839456 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Ecrin Döner (Bülbül Grill) | 30457 | DOENER (stated) | WEBSHOP,PHONE | L/A | https://buelbuel-grill.9gg.de | +49 179 2031621 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Ente von Peking | 30169 | CHINESE (stated) | WEBSHOP,PHONE | -/A | https://entevonpeking.de/ | +49 511 14011 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Enzo’s Pizza | 30165 | PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://www.pizzaenzo-hannover.de | +49 511 3522255 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | EssKultur Hannover | 30163 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://esskultur-hannover.de | +49 511 98425158 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Estragon | 30659 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.bestwestern.de/hotels/Hannover/BEST-WESTERN-Hotel-Der-Foehrenhof/gastronomie | +49 511 61540 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Farina di Nonna | - | PIZZA (stated) | WEBSHOP | -/A | https://farinadinonna.pizza/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Fasanenkrug | 30657 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.restaurant-fasanenkrug.de/ | +49 511 9055532 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Fisch Müller | - | OTHER (stated) | WEBSHOP,PHONE | L/A | https://fisch-mueller.eatbu.com/ | +49 170 5794341 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Fischerhof Pizza & Döner | - | PIZZA,DOENER (stated) | WEBSHOP | L/- | https://fischerhof-pizza-doener.eatbu.com/?lang=de | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Francesca & Fratelli | 30161 | PIZZA (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.francesca-fratelli.de/pizzamanufaktur-in-hannover/list/ | +49 511 20300775 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Frisch-Haus | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://frisch-haus.de | +49511512215 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Frites Belgique | 30159 | OTHER (stated) | WEBSHOP,PICKUP | -/A | https://frites-belgique.com | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Galeria Restaurant | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://galeria-restaurant.de/standorte/ | +49 511 3601255 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ganesha | 30453 | INDIAN (stated) | WEBSHOP,PHONE | -/A | https://restaurantganeshahannover.eatbu.com/?lang=de | +49 511 94067250 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Gartenlokal Kolonie Berggarten | - | OTHER (stated) | WEBSHOP | -/A | http://www.kgvberggartenhannover.de/vereinsheim/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Gianni | 30559 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://ristorante-gianni.com/ | +49 511 5700042 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ginkgo | 30625 | CHINESE (stated) | WEBSHOP,PHONE | -/A | https://ginkgo-hannover.de | +49 511 98438333 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Gorkha Restaurant | 30655 | INDIAN (stated) | WEBSHOP,PHONE | -/A | https://gorkha-restaurant.de/ | +49 511 54221050 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Grill am Denkmal | 30455 | OTHER | WEBSHOP,PHONE | -/A | http://grill-am-denkmal-badenstedt.de/ | +49 511 4750765 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Hansa Croque | 30627 | BURGER | WEBSHOP,PHONE | L/A | https://hansa-croque-hannover.de/ | +49 05115198585 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Happy Kumpir | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | http://www.happykumpir.de/ | +49 511 65596907 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Hdmona | - | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.hdmona-hannover.de/ | +49 176 32882563 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | heimW | - | BURGER,SUSHI (stated) | WEBSHOP,PHONE | -/A | https://heim-w.de | +49 511 2352303 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Hikari | - | ASIAN,SUSHI (stated) | WEBSHOP,PHONE | -/A | https://hikari-hannover.de/ | +4951135383855 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Hindenburg Klassik | 30175 | OTHER | WEBSHOP,PHONE | -/A | https://hindenburgklassik.de/ | +49 511 858588 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Hoflokal | 30175 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.hoflokal.de/ | +49 511 93677700 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Honey's Linden | 30451 | BURGER (stated) | WEBSHOP,PHONE | L/A | https://honeys-hannover.de/ | +49 511 94051082 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Hotel Stern | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://stern-hotel.com/ | +49 511 22013338 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | I Mori | - | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.imori-bistro.com/ | +49 511 56932047 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Il Mercato | 30163 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.ilmercato-restaurant.de/ | +49 511 39705568 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | immergrün | 30159 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://mein-immergruen.de/ | +49 511 20308064 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Insel Beach Club | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.inselbeachclub.de/ | +49511831214 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Jo's Food & Craft | 30163 | BURGER (stated) | WEBSHOP,PHONE | -/A | https://www.jos-food-craft.de/ | +49 511 45790885 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kailua | - | ASIAN (stated) | WEBSHOP,PHONE | -/A | https://kailua-hannover.de/ | +49 511 790 225 76 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kaiser's Wok | 30159 | CHINESE (stated) | WEBSHOP,PHONE | L/A | https://www.kaisers-wok.de/ | +49 511 35399246 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Kale | 30173 | TURKISH (stated) | WEBSHOP,PHONE | -/A | https://www.kale-restaurant.de | +49 511 228 395 00 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kazumi Sushi Manufaktur | 30161 | SUSHI (stated) | WEBSHOP,PHONE | -/A | https://kazumi-sushi.de/ | +49511 54610708 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kebap 63 | - | DOENER,TURKISH | WEBSHOP,PHONE | L/A | https://www.kebap63-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Kenibo | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://kenibo-ramen.de/ | +49 511 37438737 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Klaver | 30171 | OTHER | WEBSHOP | -/A | https://www.klaver-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kleines Glück | 30161 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://cafekleinesglueck.jimdofree.com/ | +49 176 6401196 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kouya Sushi | 30629 | SUSHI,ASIAN (stated) | WEBSHOP,PHONE | L/A | https://www.kouya-sushi.de/ | +49 511 56971628 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Kreta Grill | - | BURGER,GREEK,PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://www.kretagrill-hannover.de/ | 051181127004 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kreuzklappe | 30159 | TURKISH (stated) | WEBSHOP | -/A | https://restaurant-kreuzklappe.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kumkapi | 30159 | GRILL,TURKISH (stated) | WEBSHOP,PHONE | -/A | https://kumkapi-hannover.de/ | +4951112359591 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Kytaro | 30539 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://kytaro-der-grieche.de | +49 511 525252 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Casa | 30655 | OTHER (stated) | WEBSHOP,PHONE | -/A | http://restaurante-lacasa.de/ | +49 511 695192 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Castagna | 30629 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | L/A | https://la-castagna.metro.rest/ | +49 511 581515 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | La Favola | - | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.ristorante-la-favola.de/ | +495119515475 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Galleria | 30159 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.restaurant-galleria.de | +49 511 325096 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | La Plaza | 30449 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://spanier-la-plaza-hannover-linden.de/ | +49 511 60499091 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Vita | - | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://lavita-hannover.de/ | +49 511 22866120 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | LaSall Weinbar & Restaurant | 30171 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.lasall-hannover.de/ | +49 511 816663 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Lavash Back & Döner | 30167 | DOENER,TURKISH (stated) | WEBSHOP,PHONE | L/A | https://lavash-hannover.doener-curator.com/de/ | +49 511 64690753 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Layalina | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://layalina-restaurant.de/ | +49 511 16922722 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Le Vante | 30449 | OTHER (stated) | WEBSHOP,PICKUP | -/A | https://le-vante-hannover.eatbu.com | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Liners | 30159 | BURGER (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://liners-lecker.de/ | +49 511 81128940 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Lister Laube | 30179 | OTHER (stated) | WEBSHOP,PHONE | L/A | https://www.listerlaube.de/ | +49 511 371636 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Lister Liebe | 30161 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://listerliebe.de/ | 004951170815154 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Little Cortile | 30169 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://little-cortile.de/ | +49 5111316548 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Lugar de Cita Restaurant | - | VIETNAMESE (stated) | WEBSHOP,PHONE | -/A | https://lugar-de-cita.eatbu.com | +49 511 37382566 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | M&C King Kebap | 30167 | TURKISH,DOENER | WEBSHOP,PHONE | L/A | https://www.mc-king-kebab.de/ | +49 05114375477 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Ma'loa | 30159 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://maloa.com/ | +49 175 4700718 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Mamma Enzo (List) | 30161 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://mamma-enzo.de/ | +49 511 47574748 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Maremonte | 30159 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.maremonte.de/ | +49 511 3632904 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Mary's | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://marys-hannover.de/ | +49 511 3044816 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Masa | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.masa-hannover.de/ | +49 511 3530793 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Max Walloschke | 30159 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://max-walloschke.de | +49 511 13607 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Mega Döner | - | BURGER,DOENER (stated) | WEBSHOP,PICKUP | -/A | https://www.mega-doener-hannover.de | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Mephisto (Misburg) | 30629 | BURGER,INDIAN,ITALIAN,MEXICAN (stated) | WEBSHOP,PHONE | L/A | https://www.lieferservice-mephisto.de/ | +49 0511580581 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Mimis Thai Kitchen | 30169 | THAI (stated) | WEBSHOP,PHONE | -/A | https://www.mimis-thaikitchen.de/ | +4951176859736 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Mis Urfa Kebap | 30655 | TURKISH (stated) | WEBSHOP,PHONE | L/- | https://misurfa.de/ | +49 511 84402049 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | My Mem | 30449 | ASIAN,VIETNAMESE (stated) | WEBSHOP,PHONE | L/A | https://mymem1407.de/ | +49 01743272789 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mövenpick | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://marche-restaurants.de/standort/cafe-kroepcke/ | +49 511 32628445 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Namaste Linden | 30449 | INDIAN (stated) | WEBSHOP,PHONE | -/A | https://namastelinden.de/ | +49 511 53071968 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Nazar | 30159 | TURKISH (stated) | WEBSHOP,PHONE | L/A | https://nazar-hannover.de/ | +49 01733561599 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Nikopolis | 30163 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://nikopolis.net | +49 511 663193 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | noosou | 30539 | ASIAN,CHINESE,SUSHI,VIETNAMESE (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://noosou.de/locatons/noosou-hannover-bemerode-asian-fresh-kitchen/ | +49 511 39080803 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Olav's Kitchen by Möbelhaus Staude | 30165 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://olavs-kitchen.de/ | +49 511 9379842 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ong Tao | 30451 | VIETNAMESE (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.ongtao.net/ | +495114500575 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Outbax Spirit | 30655 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.outbaxspirit.de/ | +49511578251 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Palladion | 30559 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://palladion-hannover.de | +49 511 526923 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Panover | 30159 | AMERICAN (stated) | WEBSHOP,PHONE | L/- | https://www.pan-over.de/ | +49 511 79028718 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Panu Pizza & Panuozzo | 30161 | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://panu-pizza.de/ | +49 511 54442942 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pera | 30161 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://cafepera.eatbu.com/ | +49 511 344934 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Peter Pane | 30159 | BURGER (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://peterpane.de/standorte/#!/l/hannover/lange-laube-6/3087001 | +49 511 33646469 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pfannkuchenhaus | 30169 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.pfannkuchenhaus.de/ | +4951117113 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pfefferkorn | 30163 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.pfefferkornhannover.de | +49 511 660889 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Piazza Italiana Trattoria & Artisan Pizza | - | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://lapiazzaitaliana.com/ | +49 511 21906239 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pier 51 | 30173 | OTHER | WEBSHOP,PHONE | -/A | https://www.pier51.de/ | +49 511 8071800 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Pizza 96 | 30419 | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://www.pizzeria96.de/ | +49 511 76363234 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza Eat me | 30657 | PIZZA,ITALIAN,INDIAN (stated) | WEBSHOP,PHONE | L/A | https://pizzaeatme.de/ | +49 511 90883030 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizza Grande | 30159 | PIZZA (stated) | WEBSHOP,PHONE | L/A | https://pizza-grande.net/ | +49 511 16921200 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Pizza Hannover | 30173 | BURGER,GREEK,ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | L/A | http://www.pizzeriahannover.de/ | +49 0511888488 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza Haus | 30629 | ITALIAN,PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://www.haus-pizza.de | +49 511 5865555 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizza Hut | - | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://pizzahut.de/de/store-locator/pizza_hut_hannover_hauptbahnhof | +49 157 862 510 50 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizza Lust | 30559 | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://www.pizza-lust-hannover.de/ | +49 511 62666522 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizza Night | - | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://www.pizzeria-night.de/ | 05113507610 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizza Pazza - da Leo | 30539 | ITALIAN,PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://pizzapazza.de/ | +49 511 5179394 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizza Punks | 30451 | PIZZA | WEBSHOP,PHONE | L/A | https://pizza-punks-hannover.order.app.hd.digital/ | +49 051189938871 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizza Service Hannover Vital | 30449 | PIZZA (stated) | WEBSHOP,PHONE | -/A | https://www.vital-pizza-hannover.de/ | +49 511 454102 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza Slice | 30167 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://www.pizzaslice-hannover.de/ | +49 051137021472 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizza Tornado Misburg | 30629 | PIZZA,BURGER,ITALIAN (stated) | WEBSHOP,PHONE | L/- | https://www.tornadopizza.de/filialen/misburg | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza Ustad | 30453 | PIZZA (stated) | WEBSHOP,PHONE | L/A | https://www.pizzaustad.de/ | +49 511 35736668 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizzamax | 30163 | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://www.pizzamax.de/hannover/ | +4951190887799 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizzeria Aroma (Pizza Roma) | 30453 | PIZZA,ITALIAN,DOENER | WEBSHOP,PHONE | L/- | https://www.pizzaroma-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizzeria Malbat | - | ITALIAN (stated) | WEBSHOP,PICKUP,PHONE | L/A | https://www.pizzeriamalbat.de | +49 5101 9913400 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pizzeria Today | 30559 | PIZZA,ITALIAN (stated) | WEBSHOP,PHONE | L/A | https://www.pizzeriatoday.de/ | +49 511 9585808 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Play Off | - | AMERICAN,BURGER (stated) | WEBSHOP,PHONE | -/A | https://www.play-off-hannover.de/ | +495115684990 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Pommes-Helden | 30159 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://pommes-helden.de | +49 511 36010 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Radieschen | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://restaurant-radieschen.de/ | +49 511 2155261 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Raffaele's | - | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.raffaeles-hannover.de | +491784905629 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Rasoi | - | INDIAN (stated) | WEBSHOP,PHONE | -/A | https://rasoi-hannover.de/ | +49 511 693343 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Reimanns Eck | 30161 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.reimanns-eck.de | +49 511 313530 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Restaurant Marie | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.restaurantmarie.de | +49 511 65399074 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Restaurant Ofelia | 30419 | GREEK (stated) | WEBSHOP,PHONE | L/A | https://restaurant-ofelia.de/ | +49 511 44454926 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant Vienna | 30175 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.vienna-restaurant.de/ | +49 511 27900777 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Restaurante Fellini | 30161 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.ristorante-fellini.de/ | +49 511 623760 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Retro Calenberger Landterrassen | 30457 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.restaurant-retro.net | +49 511 47302787 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | RIAS BAIXAS 2 | 30449 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.riasbaixas-2.de | +49 511 1234 209 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Richards | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://richards-restaurant.de/ | +49 51378749060 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ricklinger Gasthaus Anno 1901 | 30459 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.anno1901-ricklingen.de/ | +49 511 420079 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | River Boat | - | OTHER | WEBSHOP,PHONE | -/A | https://river-boat.eatbu.com/ | +49 511 8984439 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | RiX | 30459 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.schnitzel-paradies.de/ | +49 511 64719014 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Rüpel | 30451 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.ruepel.bar/ | +%2049%20(0)%20172%20158%20675%202 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Saigon | 30171 | VIETNAMESE (stated) | WEBSHOP,PHONE | -/A | https://saigon-hannover.de/ | +49 511 37356019 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Sapori Italiani | 30519 | ITALIAN,PIZZA (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://saporiitaliani-hannover.de | +49 511 89911124 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Say Cheese! | 30459 | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://www.pizza-saycheese.de | +49 511 41047777 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Schnitzery | 30161 | OTHER (stated) | WEBSHOP | -/A | https://schnitzery.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Schorse im Leineschloss | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://schorse-im-leineschloss.de | +49 511 30302411 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Schützenhaus Kaltenweide Da Salvo | - | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.schuetzenverein-kaltenweide.de/ | +49 511 774202 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Sen Pizza Nudel Express | 30625 | DOENER,ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | L/A | http://senpizza.de/ | +49 0511550700 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Shalimar | 30159 | INDIAN (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.shalimar-hannover.de/ | +49 511 14848 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Shinebar | - | OTHER | WEBSHOP,PHONE | -/A | https://www.shinebar.de/ | +49 511 70030177 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Siam Thai Restaurant | 30165 | THAI (stated) | WEBSHOP,PHONE | -/A | https://www.siam-thai-restaurant.de/ | +49 511 84902394 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Silbervogel | 30453 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://cafe-restaurant-silbervogel.eatbu.com/ | +49 511 4104960 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Sissi und Franz | - | BURGER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.sissiundfranz.eu/hannover/ | +4951164726090 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Smoking Bianco | 30167 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://smokingbianco.de | +49 511 67913166 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Star Kebap | 30419 | DOENER,TURKISH,PIZZA,BURGER | WEBSHOP,PHONE | L/- | https://www.starkebap-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Steakhaus Kampe | 30659 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://steakhouse-kampe.de | +49 511 6405171 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Steuerndieb | 30655 | OTHER (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.steuerndieb.de/ | +49 511 909960 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Street Kitchen - Viet Cuisine | 30451 | VIETNAMESE | WEBSHOP,PHONE | L/A | https://streetkitchen-viet-cuisine-hannover.de/ | +49 511 98638834 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Ständige Vertretung | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://staev-hannover.de/ | +49 511 2138690 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Sultan Kebap Hannover | - | DOENER,TURKISH,PIZZA,BURGER | WEBSHOP,PHONE | L/- | https://www.sultankebaphannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Supperclub34 | 30161 | OTHER | WEBSHOP,PHONE | -/A | https://supperclub34.de/ | +49 511 4953 1090 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Sushi Kaiser | - | SUSHI (stated) | WEBSHOP | -/A | https://www.sushikaiser.de | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Sushi Mix Hannover | 30449 | SUSHI,ASIAN | WEBSHOP,PICKUP | -/A | https://sushimixhannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Sushifreunde | 30171 | SUSHI (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://www.ai-sushi.de/ | +49 511 89989994 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | TAI PAI | 30169 | CHINESE (stated) | WEBSHOP,PHONE | -/A | https://www.tai-pai.de/ | +49 511 885230 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Tandoori Haus | 30177 | INDIAN (stated) | WEBSHOP,PHONE | -/A | https://india-tandoori-haus.de/ | +49 511 80761717 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Taverna Asteria | 30163 | GREEK (stated) | WEBSHOP,PHONE | -/A | https://www.tavernaasteria.de/ | +49 511 90882723 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Taverne Nikala | 30159 | OTHER (stated) | WEBSHOP,PHONE | L/A | https://www.tavernenikala.de/ | +49 157 33228300 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Teichhûs | 30519 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.teichhues.de/ | +49 511 89714893 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | The living - room - | - | OTHER | WEBSHOP,PHONE | -/A | https://theliving.eu/ | +49 511 600 33 981 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | The Pizza Factory | 30167 | PIZZA (stated) | WEBSHOP,PICKUP,PHONE | L/A | http://www.thepizzafactory.de/ | +49 511 3507000 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Thessaloniki | 30165 | GREEK (stated) | WEBSHOP,PHONE | L/A | https://thessaloniki-hanover.edan.io | +49 05113506461 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | TOB-Restaurant | 30179 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.tob-restaurant.com/ | +49 511 47316900 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Toscanini | 30169 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://toscanini-hannover.de/ | +49 511 71227711 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Trattoria Ecco | 30171 | ITALIAN (stated) | WEBSHOP,PHONE | L/A | https://trattoria-ecco.eatbu.com/ | +49 511 70819235 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Trattoria il Padrino | 30659 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.trattoria-il-padrino.de | +49 511 59206147 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Trattoria Massimo | 30559 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | L/A | https://trattoria-massimo.de/ | +49 511 528092 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Urfa Deluxe Holzkohlegrill | 30459 | TURKISH (stated) | WEBSHOP,PICKUP,PHONE | -/A | https://urfadeluxe.de | +49 511 21597010 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Va Bene | 30175 | ITALIAN,PIZZA (stated) | WEBSHOP,PHONE | -/A | https://va-bene-hannover.de/ | +49511812362 | Impressum:ja Kanal:ja PLZ:ja | WEBSHOP? | - |
| [ ] | Valentino | - | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://www.kgv-flora.de/vereinsheim | +49 176 21426137 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Vegan Village | 30169 | ASIAN (stated) | WEBSHOP,PHONE | -/A | https://vegan-village.com/ | +49 511 10534296 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Vereinsgaststätte des TuS Vahrenwald 08 | 30179 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://tus-vahrenwald.de/unser-verein/vereinsgaststaette/ | +49 511635494 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Vereinsgaststätte TSV Fortuna Sachsenross | - | ITALIAN (stated) | WEBSHOP | -/A | https://www.tsvfortuna.de/clubgaststaette/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Vier Jahreszeiten | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.restaurant-vierjahreszeiten.de/ | +49 511 841212 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Viet Nam | 30173 | VIETNAMESE,ASIAN (stated) | WEBSHOP,PHONE | L/A | https://www.vietnam-hannover.de/ | +49 05113363769 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Vietal-Kitchen | 30161 | VIETNAMESE (stated) | WEBSHOP,PHONE | -/A | https://vietal-kitchen.de/hannover/ | +49 511 38877888 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Vince Trattoria | 30173 | ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://vince-trattoria.de/ | +49 511 23582164 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Voi | 30159 | ASIAN,ITALIAN (stated) | WEBSHOP,PHONE | -/A | https://voi-hannover.de/ | +49 511 54685560 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Wirtshaus Wülfel | 30519 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.wirtshaus-wuelfel.de | +49 511 16270854 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Wrapper | 30167 | TURKISH (stated) | WEBSHOP,PHONE | -/A | https://wrapper-hannover.de/ | +4951164713594 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Your Pizza Express | - | PIZZA (stated) | WEBSHOP,PHONE | L/- | https://www.yourpizza-express.de | +49 511 77955855 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | ZEUS Griechisches Restaurant | 30657 | GREEK (stated) | WEBSHOP | -/A | https://zeus-hannover.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Zum Kamin | 30159 | OTHER (stated) | WEBSHOP,PHONE | -/A | https://www.zumkamin-hannover.de/ | +49 511 320426 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Zur Eiche | 30455 | OTHER | WEBSHOP,PHONE | L/A | https://zur-eiche-cafe-bar.9gg.de | +49 0511490525 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Öz Antalya Kebap | 30459 | TURKISH (stated) | WEBSHOP,PHONE | -/A | https://www.oez-antalya.de/ | +49 511 2347801 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | ÖZ URFA 63 | - | DOENER,TURKISH (stated) | WEBSHOP | L/- | https://soez-urfa-63.eatbu.com/ | - | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | 6 Sinne | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.6sinne-hannover.de/ | +49 511 47388038 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | 993 Restaurant & Bar | 30173 | OTHER (stated) | PHONE,PICKUP | -/A | https://993-hannover.de/ | +49 511 56377742 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | [hof:geflüster] | - | OTHER (stated) | PHONE,PICKUP | -/A | http://hofgeflüster.com/ | +49 511 80606630 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Acht & Siebzig | 30169 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.achtundsiebzig.de/ | +49 051194020922 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Adesso | 30163 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://adesso-feinkost.de/index.php/start/ | +49 511 54545342 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Alanya | 30659 | TURKISH (stated) | PHONE,PICKUP | -/A | http://alanya-restaurant.de/ | +49 511 69097935 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Alioli | 30559 | OTHER (stated) | PHONE | -/A | https://spanier-hannover.de/ | +49 511 37369300 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Alte Hahnenburg | 30559 | OTHER (stated) | PHONE | -/A | https://www.alte-hahnenburg.com | +49 511 526200 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Alter Bahnhof Anderten | 30559 | OTHER (stated) | PHONE | -/A | https://www.alter-bahnhof-anderten.de | +49 511 591710 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Amici miei | 30161 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://amici-miei.de | +49 511 343829 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Aristoteles | 30165 | GREEK (stated) | PHONE,PICKUP | -/A | http://www.aristoteles-hannover.de/ | +49 511 3482141 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Artinos | 30627 | GREEK (stated) | PHONE,PICKUP | -/A | http://www.artinos-hannover.de/ | +49 511 80604345 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Asia Food Hannover | 30159 | ASIAN,SUSHI,THAI,VIETNAMESE (stated) | PHONE,PICKUP | -/A | https://asiafood-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Aspera | 30161 | TURKISH | PHONE,PICKUP | -/A | https://aspera-restaurant-hannover.de/ | +49 051189849810 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Atlantis | 30419 | GREEK,ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.atlantis-hannover.de | +49 511 753570 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Atrium | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.altes-rathaus-hannover.de/ | +49 511 3008040 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | A´Mura | 30159 | ITALIAN (stated) | PHONE | -/A | https://www.a-mura.de/ | +49 511 328665 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Baba Mia | 30159 | BURGER (stated) | PHONE,PICKUP | -/A | https://babamia.de | +49 511 60499924 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Bahnhof Leinhausen | 30419 | OTHER | PHONE | -/A | https://www.bahnhof-leinhausen.de/ | +495112794900 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Bambus Garden | - | CHINESE (stated) | PHONE | -/A | https://www.bambus-garden-kirchrode.de/ | +49 511 80 69 083 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Basil | 30163 | OTHER (stated) | PHONE | -/A | https://www.basil.de/ | +49 511 622636 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Bavarium | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.bavarium.de | +49 511 323600 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Beckmann's Restaurant & Weinhaus | - | ITALIAN (stated) | PHONE | -/A | https://www.beckmanns-weinhaus.de/ | +495111316891 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Bei Mario | - | PIZZA,ITALIAN (stated) | PHONE,PICKUP | -/A | https://beimario-listerdamm.de/ | +49 511 631412 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Beiwi | 30165 | CHINESE (stated) | PHONE,PICKUP | -/A | http://www.beiwi-buffet.de | +49 511 89943710 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Bistro Da Toni | 30163 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.bistrodatoni.de/ | +49 511 5906990 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | BLOCK HOUSE | 30159 | OTHER (stated) | PHONE | -/A | https://www.block-house.de/restaurants/hannover/am-kroepcke/ | +49 511 32 12 39 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Bohoo | 30167 | OTHER (stated) | PHONE,PICKUP | -/A | https://cafebohoo.de/ | +49 511 79095018 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | bona'me | 30159 | TURKISH,OTHER (stated) | PHONE,PICKUP | -/A | https://bona-me.de/hannover-boname/ | +49 511 12376880 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Brauereigaststätte Wienecke XI. | 30519 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.wienecke.de | +49 511 12611536 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Brela | 30625 | OTHER (stated) | PHONE,PICKUP | -/A | https://restaurant-brela.de/ | +49 511 576151 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Buddha Bowl | 30159 | ASIAN,OTHER (stated) | PHONE | L/A | https://buddha-bowl-hannover.menueat.net/ | +49 511 22863444 | Impressum:nein Kanal:nein PLZ:nein | PICKUP?,LIEFERT? | - |
| [ ] | Bull's Kitchen | 30159 | BURGER (stated) | PHONE | -/A | https://www.bullskitchen.de/ | +49 511 21900990 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Busan Chicken | 30159 | OTHER (stated) | PHONE | -/A | https://www.busan-chicken.de | +49 511 94033217 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Butschies Bistro am Maschsee | 30169 | OTHER | PHONE,PICKUP | -/A | https://butschies-bistro.de/hannover-maschsee/bistro/ | +49 5066900440 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Cafe & Bar Celona | 30159 | BURGER (stated) | PHONE | -/A | https://celona.de/cafe-bar-celona-hannover-altstadt | +49 511 3538576 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Cafe Steintormasch | 30167 | OTHER (stated) | PHONE,PICKUP | -/A | https://steintormasch-cafe.de/ | +49 511 7000717 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Café Kifaru | 30175 | BURGER,PIZZA (stated) | PHONE | -/A | https://www.zoo-hannover.de/location-kifaru | +49 511 28074163 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Café&Restaurant Korthaus | 30519 | OTHER (stated) | PHONE | -/A | https://www.cafe-korthaus.de/ | +49 511 863146 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Cham | 30161 | ASIAN,OTHER (stated) | PHONE,PICKUP | -/A | https://chamthevegankitchen.de/chamhannover | +49 511 21950700 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Cheers | 30167 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.cheers-hannover.de/ | +49 511 13461 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Chicago's | - | OTHER (stated) | PHONE | -/A | https://chicagos.de/ | +49 511 12347061 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | China Dim Sum House | 30159 | CHINESE (stated) | PHONE,PICKUP | -/A | https://www.dim-sum-hannover.de/ | +49 511 89824088 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | China Restaurant Panda | 30659 | CHINESE,ASIAN (stated) | PHONE | L/- | https://panda-hannover.de | +49 511 8980782 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | China-Imbiss-Jasmin | 30459 | ASIAN,CHINESE (stated) | PHONE,PICKUP | -/A | https://china-imbiss-jasmin-1.jimdosite.com/ | +49 511 2349870 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Clubwirt | 30453 | OTHER | PHONE,PICKUP | -/A | https://www.victoria-linden.de/Clubwirt.aspx | +49 151 54117650 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Coimbra | - | OTHER (stated) | PHONE,PICKUP | -/A | https://www.coimbra-hannover.de/ | +49 511 451858 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Crunchy snacks & more | 30169 | OTHER | PHONE,PICKUP | -/A | https://www.crunchy-hannover.de/ | +49 511 44455952 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Culinar | 30419 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.mtv-herrenhausen.de/vereinsheim | +49 511 53942084 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Curry Leaves | 30177 | INDIAN (stated) | PHONE,PICKUP | -/A | https://curryleavesrestaurant.de/ | +49 511 37024512 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Da Andrea | 30175 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://da-andrea.jimdo.com/ | +49 511 282224 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Damar Baba Döner | - | DOENER (stated) | PHONE,PICKUP | -/A | https://damarbabadoner.com/ | +49 163 3516983 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Daniel's | 30161 | OTHER (stated) | PHONE,PICKUP | -/A | https://restaurantdaniels.de/ | +49 511 3362948 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Das Ding | 30163 | BURGER (stated) | PHONE | -/A | https://www.dasding-restaurant.de | +49 511 392999 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Das Vikings | 30539 | OTHER | PHONE,PICKUP | -/A | https://www.das-vikings.de/ | +49 015201917571 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Doli | 30163 | OTHER (stated) | PHONE,PICKUP | -/A | https://doli.restaurant | +49 176 12223377 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Eckis Wirtshaus | 30449 | OTHER (stated) | PHONE | -/A | https://eckiswirts.haus/ | 017683189901 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | El Chileno | 30657 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.el-chileno.de/ | +49 051190882677 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | El Pais | 30161 | OTHER (stated) | PHONE,PICKUP | -/A | https://elpais-tapasbar.de/ | +49 511 313115 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | El Paso | - | MEXICAN (stated) | PHONE | -/A | https://www.el-paso.restaurant/ | +49 51140089477 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Elim Hotpot | 30519 | CHINESE (stated) | PHONE,PICKUP | -/A | https://www.elimrestaurant.de/ | +49 511 8988920 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Eliniko | 30171 | GREEK (stated) | PICKUP,PHONE | -/A | https://www.eliniko-hannover.de/ | +49 511 81 76 00 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Esty's Taste | 30163 | OTHER (stated) | PHONE,PICKUP | -/A | https://estystaste.com/ | +49 160 92852885 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Euphrat | 30655 | GREEK (stated) | PHONE,PICKUP | -/A | http://www.euphrat-hannover.de | +49 511 621307 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Familienrestaurant Smak | - | OTHER (stated) | PHONE,PICKUP | -/A | https://www.smak-restaurant.de/ | +49 511 98427633 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Finca Hannover | 30169 | OTHER (stated) | PHONE | -/A | https://www.finca-hannover.de/ | +49 511 1319999 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Fischers | 30451 | MEXICAN (stated) | PHONE,PICKUP | -/A | https://www.estrella-gastro.de/fischers-linden.html | +49 511 441404 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | FoodBreak20 | - | OTHER | PHONE | -/A | https://de.dussmann.de/foodbreak20 | +4951147312390 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Frittenwerk | 30159 | OTHER (stated) | PICKUP,PHONE | -/A | https://frittenwerk.com/hannover.php | +49 511 21341130 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Gallo Nero | 30655 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.gallo-nero-hannover.com/ | +49 511 5463434 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Gaststätte am Annateich | 30625 | OTHER | PHONE,PICKUP | -/A | https://annateich.de | +49 511 53327623 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Georgen Terrassen | 30167 | OTHER | PHONE,PICKUP | -/A | https://georgen-terrassen.de/ | +49 511 26295424 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Gerstenkorn | 30171 | OTHER | PHONE,PICKUP | -/A | https://www.restaurant-gerstenkorn.de/ | +49 511 281620 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Gondel | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.restaurant-gondel.de/ | +49 511 30186710 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | grüpchen | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://hotel-an-der-marktkirche.de/grupchen/ | +49 511 368640 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | H'Vin | 30657 | OTHER (stated) | PHONE,PICKUP | -/A | https://hvin.de/ | +49 511 6045222 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Hamachi | - | SUSHI (stated) | PHONE,PICKUP | -/A | https://www.hamachihannover.de/ | +49 511 37356120 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Handwerk | 30173 | OTHER (stated) | PHONE | -/A | https://handwerk-hannover.com/ | +49 511 26267588 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Hannoi Bites 87 | 30167 | VIETNAMESE (stated) | PHONE,PICKUP | -/A | https:/www.hannoibites87.de | +49 511 89852222 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Havn Bar und Restaurant | 30163 | SUSHI (stated) | PHONE | -/A | https://havn-hannover.de | +49 511 16653107 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Högers 1910 | 30171 | OTHER (stated) | PHONE,PICKUP | -/A | http://hoegers1910.de | +49 511 5106425 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Ichiban | 30159 | SUSHI (stated) | PHONE,PICKUP | -/A | https://mrphung.de/ichiban-hannover/ | +49 511 2157609 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | il piccolo nero | 30451 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.ilpiccolonero.de/ | +49 511 5391232 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Ilion | 30173 | GREEK (stated) | PHONE,PICKUP | -/A | https://www.restaurant-ilion.de/ | +49 511 814728 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Ischia | 30629 | ITALIAN (stated) | PHONE | -/A | https://www.restaurant-ischia-misburg.de/ | +49 511 588210 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Istanbul Ocakbasi | 30179 | DOENER,TURKISH (stated) | PHONE | -/A | https://www.istanbul-vahrenheide.de/ | +49 511 72737494 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Jante | 30171 | OTHER | PHONE,PICKUP | -/A | https://www.jante-restaurant.de/ | +49 511 54555606 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Jung-Gu | 30167 | ASIAN (stated) | PHONE | L/- | https://jung-gu.de/ | +49 511 60498344 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Koh-I-Noor Dhaba | 30169 | INDIAN (stated) | PHONE | -/A | https://www.kohinoor-hannover.de/ | +49 511 95483483 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Kröner | 30539 | DOENER (stated) | PHONE,PICKUP | -/A | https://www.wenndönerdannkröner.de | +49 511 22014903 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | L'Osteria | 30179 | ITALIAN (stated) | PHONE,PICKUP | L/A | https://losteria.net/de/restaurants/restaurant/hannover-vahrenwalder/ | +49 511 67696737 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Buca | 30165 | ITALIAN (stated) | PHONE | -/A | https://www.labuca.de/ | +49 511 36587001 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | La Cantina | 30161 | OTHER (stated) | PHONE,PICKUP | -/A | http://tapasparadies.eu/ | +49 511 3880210 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | La Lucania II | 30173 | PIZZA (stated) | PICKUP,PHONE | -/A | https://www.la-lucania2.de | +49 511 22899995 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | La Paella | 30177 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.lapaella.de/ | +49 511 392936 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | La Vida | 30161 | OTHER (stated) | PHONE,PICKUP | -/A | https://lavida-restaurant.de/ | +49 511 35363568 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Lazio | 30455 | PIZZA (stated) | PHONE,PICKUP | -/A | https://www.pizza-lazio-hannover.de | +49 511 494043 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Lehaha | 30519 | CHINESE (stated) | PHONE,PICKUP | -/A | http://www.restaurant-lehaha.de/ | +49 511 56968858 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Leinegold | 30175 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.leinegold.com/ | +49 511 3889654 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Levante | 30659 | OTHER (stated) | PHONE | -/A | http://www.levante-hannover.de/ | +49 511 9055932 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Lieblingsbar | 30419 | OTHER (stated) | PHONE | -/A | https://lieblingsbar.de/ | +49 511 76809126 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Limmehr | 30453 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.limmehr.de/ | +49 511 211155 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Lindener Bergterrasse | 30449 | GRILL,ITALIAN (stated) | PHONE | -/A | https://lindener-bergterrassen.eatbu.com/?lang=de | +491734322327 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Lister Döner (Prinz) | 30161 | DOENER,TURKISH,GRILL | PHONE,PICKUP | -/A | https://listerdoener.de/ | +49 511 21912566 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Loretta's | 30169 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.lorettas-hannover.de/ | +49 511 5905780 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Lucht's Grill | 30177 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.luchts-grill.de/Home | +49 511 695365 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Lukullus | 30453 | GREEK (stated) | PHONE | -/A | https://www.lukullus-hannover.de | +49 511 482471 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Malatya Grill | 30625 | TURKISH (stated) | PHONE,PICKUP | -/A | https://malatyagrill.de/ | +49 05115547605 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Mangal's Kitchen | 30163 | INDIAN (stated) | PHONE,PICKUP | -/A | https://restaurant-mangals-kitchen.de/ | +49 511 64693150 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Marijas Nudelparadies | 30177 | ITALIAN (stated) | PHONE | L/- | https://marijasnudelparadies.com/ | +49 511 623285 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Marâa Beef Club | - | OTHER (stated) | PHONE,PICKUP | -/A | https://bogabeef.de | +49 176 70238862 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Meiers Lebenslust | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.meiers-lebenslust.de/ | +49 511 8982250 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mel's Diner | - | AMERICAN (stated) | PHONE,PICKUP | -/A | https://www.mels-diner.de/ | +49 511 862310 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mensa HMTMH | 30175 | OTHER | PICKUP,PHONE | -/A | https://www.studentenwerk-hannover.de/essen/mensen-und-cafes/Mensa%20HMTMH | 0511-3100217 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Meteora | 30161 | GREEK (stated) | PHONE,PICKUP | -/A | https://www.meteora-hannover.de | +49 511 315237 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mezem | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://mezemrestaurant.de/ | +49 511 51512170 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Milazzo | 30625 | ITALIAN,PIZZA (stated) | PHONE | -/A | https://restaurant-milazzo.de | +49 511 556601 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Mimi Fusion | - | ASIAN,VIETNAMESE,SUSHI (stated) | PHONE,PICKUP | -/A | http://mimifusion.de | +49 511 84489696 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mio Mio | - | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.miomiolinden.de/ | +49 511 54358283 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Mon Bonheur | 30163 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.monbonheur.de | +49 511 53078717 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Montelliana | 30539 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.restaurant-montelliana.de | +49 511 98226689 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Napoli 47 | 30451 | PIZZA (stated) | PHONE,PICKUP | -/A | https://napoli47.de | +49 511 48973171 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Nefis | 30167 | TURKISH (stated) | PHONE | L/- | https://nefishannover.de/ | +49 051149538959 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | NY Italian Buffet | 30159 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.ny-italian.com/hannover-city | +49 162 7880673 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | O'Atlantico | 30451 | OTHER (stated) | PHONE | -/A | https://www.spanische-restaurants.com/oatlantico/ | +49 511 448239 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Ombra | - | ITALIAN (stated) | PHONE,PICKUP | -/A | https://ombra-hannover.de/ | +49 152 27655273 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Oregano Grillhaus | 30419 | GREEK (stated) | PHONE,PICKUP | -/A | https://oregano-grill.com/ | +49 511 76800230 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Palios | 30659 | GREEK (stated) | PHONE,PICKUP | -/A | https://restaurant-palios.de/ | +49 511 80603291 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Papa Enzos | 30169 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | https://www.papaenzos-hannover.de/ | +49 05119886061 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Parkrestaurant | 30175 | OTHER (stated) | PHONE,PICKUP | -/A | https://hcc-parkrestaurant.de/ | +49 511 81130 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pasta & Pizza | 30167 | ITALIAN,PIZZA (stated) | PHONE | -/A | https://pastaundpizza-hannover.de | +49511 703268 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Pharos | 30177 | OTHER (stated) | PHONE,PICKUP | -/A | https://pharos-restaurant.de/ | +49 511 6965603 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pho 3 mien | 30159 | ASIAN (stated) | PHONE,PICKUP | -/A | http://www.pho3mien.de | +49 511 10531443 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pho Viet Nam | 30159 | ASIAN (stated) | PHONE,PICKUP | -/A | https://vietnampho.de/ | +49 511 8972345 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Piccoliâs Roadhouse | 30159 | AMERICAN (stated) | PHONE,PICKUP | -/A | https://piccolis-roadhouse.de/home.html | +49 511 7011888 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Piri Piri | 30451 | PIZZA,GRILL (stated) | PHONE | L/- | https://piripirihannover.de/ | +49 152 11351188 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Pizza Bulls | 30625 | PIZZA (stated) | PHONE,PICKUP | -/A | https://www.pizzabulls.de/unsere-filialen/hannover-kleefeld | +49 176 20465326 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizza Familia | 30519 | BURGER,PIZZA (stated) | PHONE,PICKUP | -/A | https://www.pizzafamilia.de/ | +49 511 86693972 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizza Freund | 30179 | PIZZA,ITALIAN (stated) | PHONE | L/- | https://www.pizzafreundhannover.de/ | +49 511 666555 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | Pizza Günes | 30451 | PIZZA (stated) | PHONE,PICKUP | -/A | https://pizza-guenes.de | +49 051189700794 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza House | 30161 | PIZZA,ITALIAN | PHONE | L/- | https://www.pizza-house-hannover.de/ | +49 511 89841100 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Pizza Mario | 30519 | ITALIAN,PIZZA (stated) | PHONE,PICKUP | -/A | http://www.hannoverpizza.de | +49 511 868681 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Pizzeria Riccardo | 30159 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | https://www.pizzeria-riccardo-hannover.de/ | +49 511 14245 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Presto Zelos | 30459 | PIZZA,DOENER,GREEK (stated) | PHONE | L/- | https://prestozelos.de/ | +49 511 89814051 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Raj | 30519 | INDIAN (stated) | PHONE,PICKUP | -/A | https://raj-hannover.de/ | +49 511 8991213 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Rembetiko | 30539 | GREEK (stated) | PHONE,PICKUP | -/A | https://www.rembetiko-hannover.de/de | +49 511 12374152 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant & Bar NUOVO | 30659 | BURGER (stated) | PHONE | -/A | https://www.nuovo-restaurant.de/ | +49 511 71300792 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Restaurant Achilles | 30163 | GREEK (stated) | PHONE,PICKUP | -/A | https://www.www.achilles-hannover.de/ | +49 511 622227 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant Donau | 30519 | OTHER (stated) | PHONE,PICKUP | -/A | https://restaurant-donau.de/ | +49 511 864003 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant Hiller | 30159 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.restaurant-hiller.de/ | +49 511 321288 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant im Polizei-Sportverein | 30625 | OTHER (stated) | PHONE | -/A | https://psv-hannover.de/ | +49 511 875 6530 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Restaurant im Sportpark | - | BURGER,GRILL,ITALIAN,PIZZA (stated) | PHONE | -/A | https://restaurant-am-sportpark.eatbu.com/?lang=de | +4951121906122 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Restaurant Oikos | 30559 | GREEK (stated) | PHONE,PICKUP | -/A | https://oikos-hannover.de/ | +49 511 78091201 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant Otts | 30159 | OTHER (stated) | PHONE | -/A | https://www.restaurant-otts.de/ | +49 511 344921 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Restaurant Piano | 30655 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.restaurant-piano.de/index.php | +49 511 45913666 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurant Schwanenburg | 30453 | OTHER (stated) | PHONE,PICKUP | -/A | https://schwanenburg.net/ | +49 511 2131701 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Restaurante Perschia | 30519 | OTHER (stated) | PICKUP,PHONE | L/A | https://www.restaurant-perschia.de/ | +49 511 87568087 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Ristorante Botticelli | 30659 | ITALIAN (stated) | PHONE | -/A | https://www.botticelli-hannover.de | +49 511 27018360 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Ristorante Lucca | 30559 | ITALIAN (stated) | PHONE | -/A | https://www.lucca-ecco.de/ | +49 511 65512256 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Ristorantino Stromboli | 30177 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.ristorantino-stromboli.de/ | +49 511 87949392 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Riva | 30173 | OTHER | PHONE,PICKUP | -/A | https://riva-hannover.com/ | +49 511 97827687 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Romantico | 30629 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://romantico-hannover.de | +49 511 54458221 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Rotonda Bistro Origlio | 30159 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://ristorante-rotonda.de/rotonda-bistro-origlio/ | +49 511 324104 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Roy's Restaurant | 30175 | ITALIAN (stated) | PICKUP,PHONE | -/A | https://www.roys-hannover.de/ | +49 511 89767671 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Royal Donuts | 30451 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.royal-donuts.de/ | +49 511 44455678 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Ruenthai | 30159 | ASIAN (stated) | PHONE | -/A | https://www.ruenthai.de/ | +49 511 328999 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Safran | 30159 | OTHER (stated) | PHONE | -/A | https://safran-hannover.eatbu.com/?lang=de | +4951164712019 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Sagir | 30171 | INDIAN (stated) | PHONE,PICKUP | -/A | http://www.sagir-restaurant.de/ | +49 511 2353593 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Salatfreunde | 30161 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.salatfreunde.de/ | +49 171 1112114 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Salentino | 30161 | ITALIAN (stated) | PHONE | -/A | https://italiener-hannover.de | +49 511 3882782 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Schlossküche Herrenhausen | 30419 | OTHER (stated) | PHONE,PICKUP | -/A | http://www.schlosskueche-herrenhausen.de | +49 511 2794940 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Schützenhaus Anderten | 30559 | OTHER (stated) | PHONE | -/A | https://schuetzenhaus-anderten.de | +49 511 528644 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Shabba Dee's Kitchen | - | OTHER (stated) | PHONE,PICKUP | -/A | https://www.shabbadeeskitchen.com/ | +49 173 7175042 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Shin Ramen | 30159 | ASIAN (stated) | PHONE | -/A | https://www.shin-foods.com/de/ | +495115474240 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Sindo Sushi | 30163 | ASIAN,SUSHI (stated) | PHONE,PICKUP | -/A | https://www.sindo-restaurant.de/ | +49 511 661188 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Siro's Pizza | 30165 | PIZZA,ITALIAN (stated) | PHONE | L/- | https://sirospizza.de/ | +49 511 39084080 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Sole Mio | - | ITALIAN (stated) | PHONE,PICKUP | -/A | https://solemio-hannover.de | +49 511 61659270 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Soulkitchen | 30449 | OTHER (stated) | PHONE | -/A | http://soulkitchen-linden.de/ | +49 511 45008510 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Speiserei | 30175 | OTHER (stated) | PHONE | -/A | https://speiserei-hannover.de/ | +49 511 858921 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Spoon | 30161 | ITALIAN,PIZZA (stated) | PHONE | -/A | https://www.spoon-hannover.de | +49 162 3068657 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Spätzle Haus | 30419 | OTHER (stated) | PHONE | -/A | https://www.spaetzlehaus.de | +49 511 795433 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://www.stadtmauer-hannover.de/ | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://stadtmauer-hannover.de/index3.php | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://stadtmauer-hannover.de/ | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://www.stadtmauer-hannover.de/index2.php | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Stromboli | 30163 | ITALIAN (stated) | PHONE | -/A | https://ristorantino-stromboli.de/ | +49 511 87949392 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Suppenhandlung | 30167 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.suppenhandlung.de/ | +49 051134083630 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Sushi Gim | 30169 | ASIAN,SUSHI (stated) | PHONE,PICKUP | -/A | https://sushi-bar-gim.de/ | +49 511 7000259 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Sushi-Do | 30159 | ASIAN,SUSHI (stated) | PHONE | -/A | https://www.sushi-do.de/ | +49 511 2203572 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Symposion | - | GREEK (stated) | PHONE,PICKUP | -/A | https://www.symposion-restaurant.de/ | +49 511 816100 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Taj Mahal | 30175 | INDIAN (stated) | PHONE | -/A | https://www.tajmahal.de/ | +49 511 3481714 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Tanara | 30625 | OTHER (stated) | PHONE,PICKUP | -/A | https://tanara-restaurant.de | +49 511 559371 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Tandure | 30167 | TURKISH (stated) | PHONE,PICKUP | -/A | https://www.tandure.de/ | +49 172 3007951 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Tante Franz | 30167 | OTHER (stated) | PHONE,PICKUP | -/A | https://tantefranz.com | +49 511 21576207 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Tesoro | 30171 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.ristorante-tesoro.de/ | +49 511 89931134 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Thai Food in the Box | 30159 | THAI (stated) | PHONE,PICKUP | -/A | https://www.thaifood-inthebox.de/ | +49 511 1692245 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | The Wild Duck | 30177 | ASIAN (stated) | PHONE,PICKUP | -/A | https://thewildduck.de | +49 511 84868464 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Tina II | 30655 | GREEK (stated) | PHONE | -/A | https://www.restaurant-tina2.de | +49 511 6479400 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Tomo Sushi | 30175 | SUSHI,ASIAN (stated) | PHONE,PICKUP | L/A | https://tomosushi.de/ | +49 511 343443 | Impressum:nein Kanal:nein PLZ:nein | - | - |
| [ ] | Trattoria da Giorgio | 30449 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.trattoria-dagiorgio-hannover.de/ | +49 511 455453 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Treibhaus | 30163 | ITALIAN,MEXICAN,OTHER (stated) | PHONE,PICKUP | -/A | http://www.treibhaus-hannover.de | +49 511 664411 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | TRIO Ristorantino Eiscafe und Bar | 30625 | ITALIAN (stated) | PHONE | -/A | https://trio-restaurant.de/ | +49 511 3533195 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Trocadero | 30419 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.restaurant-trocadero.de/ | +49 511 4754135 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Tru Story | - | ASIAN (stated) | PHONE | -/A | https://tru-story.de | +49 511 21552960 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Veraci | - | ITALIAN (stated) | PHONE,PICKUP | -/A | https://veraci-hannover.de/ | +49 511 64714598 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Vina 97 Restaurant | - | ASIAN (stated) | PHONE,PICKUP | -/A | https://www.vina97restaurant.com/ | +49 511 2102888 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | vino kebab | 30459 | DOENER,PIZZA,TURKISH (stated) | PHONE,PICKUP | L/A | https://restaurant-zaza.de/ | +49 511 64710665 | Impressum:nein Kanal:nein PLZ:nein | LIEFERT? | - |
| [ ] | vorveg | 30169 | OTHER (stated) | PHONE | -/A | https://www.vorveghannover.de | +49 151 57725191 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Werkhof Restaurant | 30167 | OTHER (stated) | PHONE | -/A | https://werkhof-hannover.de/restaurant | +49 511 35356380 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
| [ ] | Wirtshaus Hannover | 30159 | OTHER (stated) | PICKUP,PHONE | -/A | https://wirtshaus-hannover.de/ | +49 511 99999691 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Zio Totonno | 30171 | ITALIAN (stated) | PHONE,PICKUP | -/A | https://www.zio-totonno.de/ | +49 511 8074418 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Zorbas | 30419 | GREEK (stated) | PICKUP,PHONE | -/A | https://www.zorbas-in-hannover.de/ | +49 511 637292 | Impressum:ja Kanal:ja PLZ:ja | - | - |
| [ ] | Zurück zum Glück | 30175 | OTHER (stated) | PHONE,PICKUP | -/A | https://www.zurueckzumglueck.de | +49 511 89978880 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | ÎÎÎÎÎÎ£ | 30169 | GREEK,INDIAN (stated) | PHONE,PICKUP | -/A | https://www.anemos-hannover.de | +49 511 95483483 | Impressum:nein Kanal:nein PLZ:nein | PICKUP? | - |
| [ ] | Öz Urfa | 30169 | TURKISH (stated) | PHONE | -/A | https://www.oezurfa.de/ | 05111319079 | Impressum:ja Kanal:ja PLZ:ja | PICKUP? | - |
