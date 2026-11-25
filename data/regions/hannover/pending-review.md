# Pending Review hannover (585 Eintraege, WEBSHOP zuerst, dann Name)

Badge "Verifizierung offen" verschwindet in der App, wenn im Eintrag gesetzt: `"status": "verified"` + `"lastVerified": "<heute>"`.
QS pro Eintrag: 1) PLZ in `postcodes` der Region, 2) Impressum + eigener Kanal (kein Plattform-Redirect), 3) Kueche: stated uebernehmen, sonst Speisen analysieren -> `cuisineSource: "derived"` + Vermerk in notes, 4) delivers/pickup nur mit Nachweis, 5) status=verified + lastVerified.
Danach: `python tools\validate_data.py` -> Assets spiegeln -> commit/push. Liste danach neu erzeugen (Snapshot).

| [ ] | Name | PLZ | Kueche | Kanal | Lief./Abh. | Website | Tel | Pipeline: Impres./Kanal/PLZ | Reasons |
|-----|------|-----|-------|-------|-----------|---------|-----|---------------------------|---------|
| [ ] | 11A | 30449 | OTHER | WEBSHOP,PHONE | -/A | https://www.11a-restaurant.de/ | +49 511 5901111 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | 6 Sinne Riverside | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://6sinne-hannover.de/ | +49 511 99987452 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | 60 seconds to napoli | 30159 | PIZZA | WEBSHOP | -/A | https://60secondstonapoli.de/standort/hannover/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Agorino | 30625 | ITALIAN,PIZZA | WEBSHOP,PICKUP,PHONE | -/A | https://agorino.de/ | +49 511 53335333 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Al-Dar | 30175 | OTHER | WEBSHOP | -/A | https://aldar.de/restaurant/hannover/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Alte Ricklinger Bierquelle | 30459 | OTHER | WEBSHOP,PHONE | -/A | https://alte-ricklinger-bierquelle.de/ | +49 511 70034038 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ambrosia | 30655 | GREEK | WEBSHOP | -/A | https://ambrosia-restaurant.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Antalya Döner | 30629 | TURKISH,DOENER | WEBSHOP,PHONE | L/A | https://www.antalyadoener-hannover.de/ | +49 01735611627 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Aresto | 30159 | GREEK | WEBSHOP,PHONE | -/A | https://www.aresto.de/ | +49 511 323759 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | AREZZO | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://ristorante-arezzo.eatbu.com | +49 511 72746930 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Cong | 30459 | ASIAN,CHINESE,THAI,VIETNAMESE | WEBSHOP,PHONE | L/A | https://www.asia-cong-hannover.de/ | +49 511 89814075 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Dao | 30451 | ASIAN,VIETNAMESE,THAI,SUSHI | WEBSHOP,PHONE | L/A | https://asia-dao.de/ | +49 511 53430929 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Dr. Wok | 30159 | ASIAN,THAI,VIETNAMESE | WEBSHOP,PHONE | -/A | https://asia-dr-wok-hannover.jimdofree.com/ | +49 511 67518046 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Asia Gourmet | - | ASIAN | WEBSHOP | -/A | https://www.asiagourmet.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Asianativ | - | ASIAN | WEBSHOP,PHONE | -/A | https://www.asianativ.de/ | +49 511 59202936 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Atas Kebab House | 30165 | DOENER,GRILL,PIZZA | WEBSHOP,PHONE | -/A | https://atas-kebab-house.eatbu.com | +49 511 54300378 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Badenstedter Döner | 30455 | DOENER | WEBSHOP,PHONE | -/A | https://badenstedter-doener.eatbu.com | +49 511 56967010 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | BAMBUS - Asia Bistro | - | ASIAN | WEBSHOP,PHONE | L/- | https://www.asiabambus.de/ | +49 511755422 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bar Añejo | 30451 | OTHER | WEBSHOP,PHONE | -/A | https://www.bar-anejo.com | +4951149537241 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Baratie | 30173 | BURGER | WEBSHOP,PHONE | L/A | https://www.baratiehannover.de/ | +49 176 82157476 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Beckers | - | OTHER | WEBSHOP | -/A | https://www.beckers-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Beef and Reef | 30171 | OTHER | WEBSHOP,PHONE | -/A | https://www.beefandreef.de/ | +49 511 54356738 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bei Ranko | 30629 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | http://restaurant-ranko.de | +49 511 582357 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bestia Vera Pizza Napoletana | 30159 | PIZZA | WEBSHOP,PHONE | -/A | https://www.bestia.pizza | +49 511 41088730 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bistro Emporio | 30453 | ITALIAN | WEBSHOP,PICKUP,PHONE | -/A | https://www.rossini-gmbh.de/ | +49 511 423388 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bistro-Bringdienst da Toni | 30163 | PIZZA | WEBSHOP,PICKUP,PHONE | -/A | https://www.bringdienst-da-toni.de/ | +49 511 967 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bodega Argentina | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://bodega-argentina.de/ | +49 1516 1487628 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bosco | - | ITALIAN | WEBSHOP | -/A | https://ristorantebosco.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Brauhaus Ernst-August | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://www.brauhaus.net/ | +49 511 365950 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Broyhan Haus | - | OTHER | WEBSHOP,PHONE | -/A | https://www.broyhanhaus.de/ | +49 511 323919 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Brudis Döner & Burger | 30419 | BURGER,DOENER | WEBSHOP,PHONE | L/A | https://brudis-db.de | +49 051153558445 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Brunnenhof | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://restaurantbrunnenhof.de | +49 511 3683920 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Buddha Bowl | 30159 | ASIAN,OTHER | WEBSHOP,PHONE | L/A | https://buddha-bowl-hannover.menueat.net/ | +49 511 22863444 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Burger Hannover | 30171 | BURGER | WEBSHOP,PICKUP,PHONE | L/A | https://burgerhannover.de | +49 511 35386300 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Burgermeister | 30451 | BURGER | WEBSHOP,PICKUP,PHONE | -/A | https://burgermeister.com/ | +49 511 12371790 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Castello | 30419 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.castello-hannover.de/ | +49 511 751289 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | cavallo - Königliche Reithalle | - | OTHER | WEBSHOP,PHONE | -/A | https://www.cavallo-reithalle.de | 05112889911 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | China-Restaurant Mo | 30457 | CHINESE | WEBSHOP,PHONE | -/A | https://www.chinarestaurantmo.de/ | +49 511 434370 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Chiuy Phat | 30161 | VIETNAMESE | WEBSHOP,PHONE | -/A | https://thuyphat.de/ | 051154534773 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Com Viet | - | VIETNAMESE | WEBSHOP,PHONE | -/A | https://www.comviethannover.de/ | +49 511 64660344 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Costas Greek Taverna | 30163 | GREEK | WEBSHOP,PHONE | -/A | https://www.costas-taverne.de/ | +49 511 697103 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Curry Culum | 30159 | BURGER | WEBSHOP,PHONE | -/A | https://www.curryculum.de/ | +49 511 47399361 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Da Gennaro Trattoria | 30177 | ITALIAN,PIZZA | WEBSHOP,PHONE | -/A | https://dagennaro.de/ | +49 511 39083833 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Da Lello | 30171 | ITALIAN | WEBSHOP,PICKUP,PHONE | L/A | http://ristorante.dalello.de/ | +49 511 32 07 05 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Das Zwiespalt | 30449 | OTHER | WEBSHOP,PHONE | L/A | https://daszwiespalt.de | +49 511 54397753 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | dean&david | 30161 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://deananddavid.com/lister-meile-hannover/ | +49 511 45011187 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | doydoy´s | 30175 | PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://shop.liefersoft.de/doydoys-pizza-30175-e0 | +4951121906834 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Döner King 1 | 30519 | DOENER | WEBSHOP,PHONE | -/A | https://www.donerkinghannover.de | +49 151 62839456 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ecrin Döner (Bülbül Grill) | 30457 | DOENER | WEBSHOP,PHONE | L/A | https://buelbuel-grill.9gg.de | +49 179 2031621 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | El Greco | 30559 | GREEK | WEBSHOP,PHONE | -/A | https://elgreco-hannover.de/ | +49 511 528924 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Elektra-Bringdienst | - | GREEK | WEBSHOP,PICKUP | L/A | https://www.elektrabringdienst.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Empelder Pizza Station 464633 465498 | - | PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://pizza-station-empelde.de/ | +49 511 464633; +49 511 465498 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ente von Peking | 30169 | CHINESE | WEBSHOP,PHONE | -/A | https://entevonpeking.de/ | +49 511 14011 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Enzo’s Pizza | 30165 | PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://www.pizzaenzo-hannover.de | +49 511 3522255 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | EssKultur Hannover | 30163 | OTHER | WEBSHOP,PHONE | -/A | https://esskultur-hannover.de | +49 511 98425158 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Estragon | 30659 | OTHER | WEBSHOP,PHONE | -/A | https://www.bestwestern.de/hotels/Hannover/BEST-WESTERN-Hotel-Der-Foehrenhof/gastronomie | +49 511 61540 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Farina di Nonna | - | PIZZA | WEBSHOP | -/A | https://farinadinonna.pizza/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Fasanenkrug | 30657 | OTHER | WEBSHOP,PHONE | -/A | https://www.restaurant-fasanenkrug.de/ | +49 511 9055532 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Fisch Müller | - | OTHER | WEBSHOP,PHONE | L/A | https://fisch-mueller.eatbu.com/ | +49 170 5794341 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Fischerhof Pizza & Döner | - | PIZZA,DOENER | WEBSHOP,PICKUP | L/A | https://fischerhof-pizza-doener.eatbu.com/?lang=de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Francesca & Fratelli | 30161 | PIZZA | WEBSHOP,PICKUP,PHONE | -/A | https://www.francesca-fratelli.de/pizzamanufaktur-in-hannover/list/ | +49 511 20300775 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Frisch-Haus | - | OTHER | WEBSHOP,PHONE | -/A | https://frisch-haus.de | +49511512215 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Frites Belgique | 30159 | OTHER | WEBSHOP,PICKUP | -/A | https://frites-belgique.com | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Galaxia | - | OTHER | WEBSHOP | -/A | https://www.cafebarrestaurant-galaxia.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Galeria Restaurant | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://galeria-restaurant.de/standorte/ | +49 511 3601255 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ganesha | 30453 | INDIAN | WEBSHOP,PHONE | -/A | https://restaurantganeshahannover.eatbu.com/?lang=de | +49 511 94067250 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gartenlokal Kolonie Berggarten | - | OTHER | WEBSHOP | -/A | http://www.kgvberggartenhannover.de/vereinsheim/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Gianni | 30559 | ITALIAN | WEBSHOP,PHONE | -/A | https://ristorante-gianni.com/ | +49 511 5700042 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ginkgo | 30625 | CHINESE | WEBSHOP,PHONE | -/A | https://ginkgo-hannover.de | +49 511 98438333 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Gorkha Restaurant | 30655 | INDIAN | WEBSHOP,PHONE | -/A | https://gorkha-restaurant.de/ | +49 511 54221050 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Grill am Denkmal | 30455 | OTHER | WEBSHOP,PHONE | -/A | http://grill-am-denkmal-badenstedt.de/ | +49 511 4750765 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Hansa Croque | 30627 | BURGER | WEBSHOP,PHONE | L/A | https://hansa-croque-hannover.de/ | +49 05115198585 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Happy Kumpir | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | http://www.happykumpir.de/ | +49 511 65596907 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Haus des Döners | 30161 | DOENER | WEBSHOP,PICKUP | -/A | https://hausdesdoners.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Hdmona | - | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://www.hdmona-hannover.de/ | +49 176 32882563 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | heimW | - | BURGER,SUSHI | WEBSHOP,PHONE | -/A | https://heim-w.de | +49 511 2352303 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Hikari | - | ASIAN,SUSHI | WEBSHOP,PHONE | -/A | https://hikari-hannover.de/ | +4951135383855 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Hindenburg Klassik | 30175 | OTHER | WEBSHOP,PHONE | -/A | https://hindenburgklassik.de/ | +49 511 858588 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Hoflokal | 30175 | OTHER | WEBSHOP,PHONE | -/A | https://www.hoflokal.de/ | +49 511 93677700 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Honey's Linden | 30451 | BURGER | WEBSHOP,PHONE | L/A | https://honeys-hannover.de/ | +49 511 94051082 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Hotel Stern | - | OTHER | WEBSHOP,PHONE | -/A | https://stern-hotel.com/ | +49 511 22013338 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | I Mori | - | ITALIAN | WEBSHOP,PHONE | -/A | https://www.imori-bistro.com/ | +49 511 56932047 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Il Mercato | 30163 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.ilmercato-restaurant.de/ | +49 511 39705568 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | immergrün | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://mein-immergruen.de/ | +49 511 20308064 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Insel Beach Club | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.inselbeachclub.de/ | +49511831214 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Jo's Food & Craft | 30163 | BURGER | WEBSHOP,PHONE | -/A | https://www.jos-food-craft.de/ | +49 511 45790885 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kailua | - | ASIAN | WEBSHOP,PHONE | -/A | https://kailua-hannover.de/ | +49 511 790 225 76 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kaiser's Wok | 30159 | CHINESE | WEBSHOP,PHONE | L/A | https://www.kaisers-wok.de/ | +49 511 35399246 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kale | 30173 | TURKISH | WEBSHOP,PHONE | -/A | https://www.kale-restaurant.de | +49 511 228 395 00 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kazumi Sushi Manufaktur | 30161 | SUSHI | WEBSHOP,PHONE | -/A | https://kazumi-sushi.de/ | +49511 54610708 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kebap 63 | - | DOENER,TURKISH | WEBSHOP,PHONE | L/A | https://www.kebap63-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kenibo | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://kenibo-ramen.de/ | +49 511 37438737 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Klaver | 30171 | OTHER | WEBSHOP | -/A | https://www.klaver-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kleines Glück | 30161 | ITALIAN,PIZZA | WEBSHOP,PHONE | -/A | https://cafekleinesglueck.jimdofree.com/ | +49 176 6401196 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kouya Sushi | 30629 | SUSHI,ASIAN | WEBSHOP,PHONE | L/A | https://www.kouya-sushi.de/ | +49 511 56971628 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kreta Grill | - | BURGER,GREEK,PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://www.kretagrill-hannover.de/ | 051181127004 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kreuzklappe | 30159 | TURKISH | WEBSHOP | -/A | https://restaurant-kreuzklappe.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kumkapi | 30159 | GRILL,TURKISH | WEBSHOP,PHONE | -/A | https://kumkapi-hannover.de/ | +4951112359591 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kytaro | 30539 | GREEK | WEBSHOP,PHONE | -/A | https://kytaro-der-grieche.de | +49 511 525252 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Casa | 30655 | OTHER | WEBSHOP,PHONE | -/A | http://restaurante-lacasa.de/ | +49 511 695192 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Castagna | 30629 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://la-castagna.metro.rest/ | +49 511 581515 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Favola | - | ITALIAN | WEBSHOP,PHONE | -/A | https://www.ristorante-la-favola.de/ | +495119515475 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Galleria | 30159 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.restaurant-galleria.de | +49 511 325096 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Plaza | 30449 | OTHER | WEBSHOP,PHONE | -/A | https://spanier-la-plaza-hannover-linden.de/ | +49 511 60499091 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Vita | - | PIZZA | WEBSHOP,PHONE | -/A | https://lavita-hannover.de/ | +49 511 22866120 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | LaSall Weinbar & Restaurant | 30171 | OTHER | WEBSHOP,PHONE | -/A | https://www.lasall-hannover.de/ | +49 511 816663 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lavash Back & Döner | 30167 | DOENER,TURKISH | WEBSHOP,PHONE | L/A | https://lavash-hannover.doener-curator.com/de/ | +49 511 64690753 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Layalina | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://layalina-restaurant.de/ | +49 511 16922722 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Le Vante | 30449 | OTHER | WEBSHOP,PICKUP | -/A | https://le-vante-hannover.eatbu.com | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Liners | 30159 | BURGER | WEBSHOP,PICKUP,PHONE | L/A | https://liners-lecker.de/ | +49 511 81128940 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lister Laube | 30179 | OTHER | WEBSHOP,PHONE | L/A | https://www.listerlaube.de/ | +49 511 371636 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lister Liebe | 30161 | ITALIAN,PIZZA | WEBSHOP,PHONE | -/A | https://listerliebe.de/ | 004951170815154 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Little Cortile | 30169 | ITALIAN | WEBSHOP,PHONE | -/A | https://little-cortile.de/ | +49 5111316548 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lugar de Cita Restaurant | - | VIETNAMESE | WEBSHOP,PHONE | -/A | https://lugar-de-cita.eatbu.com | +49 511 37382566 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | M&C King Kebap | 30167 | TURKISH,DOENER | WEBSHOP,PHONE | L/A | https://www.mc-king-kebab.de/ | +49 05114375477 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ma'loa | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://maloa.com/ | +49 175 4700718 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mamma Enzo (List) | 30161 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://mamma-enzo.de/ | +49 511 47574748 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Maremonte | 30159 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.maremonte.de/ | +49 511 3632904 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mary's | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://marys-hannover.de/ | +49 511 3044816 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Masa | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://www.masa-hannover.de/ | +49 511 3530793 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Max Walloschke | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://max-walloschke.de | +49 511 13607 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mega Döner | - | BURGER,DOENER | WEBSHOP,PICKUP | -/A | https://www.mega-doener-hannover.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mekong Asia Bistro | 30167 | ASIAN | WEBSHOP,PICKUP,PHONE | -/A | https://www.mekonghannover.de/ | +49 511 1698495 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mephisto (Misburg) | 30629 | BURGER,INDIAN,ITALIAN,MEXICAN | WEBSHOP,PHONE | L/A | https://www.lieferservice-mephisto.de/ | +49 0511580581 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mimis Thai Kitchen | 30169 | THAI | WEBSHOP,PHONE | -/A | https://www.mimis-thaikitchen.de/ | +4951176859736 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mis Urfa Kebap | 30655 | TURKISH | WEBSHOP,PHONE | L/- | https://misurfa.de/ | +49 511 84402049 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | My Mem | 30449 | ASIAN,VIETNAMESE | WEBSHOP,PHONE | L/A | https://mymem1407.de/ | +49 01743272789 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mövenpick | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://marche-restaurants.de/standort/cafe-kroepcke/ | +49 511 32628445 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Namaste Linden | 30449 | INDIAN | WEBSHOP,PHONE | -/A | https://namastelinden.de/ | +49 511 53071968 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Nazar | 30159 | TURKISH | WEBSHOP,PHONE | L/A | https://nazar-hannover.de/ | +49 01733561599 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Nem Viet | 30167 | VIETNAMESE | WEBSHOP,PICKUP,PHONE | -/A | https://www.nemviethannover.de/ | +49 511 702101 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Nikopolis | 30163 | GREEK | WEBSHOP,PHONE | -/A | https://nikopolis.net | +49 511 663193 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | noosou | 30539 | ASIAN,CHINESE,SUSHI,VIETNAMESE | WEBSHOP,PICKUP,PHONE | -/A | https://noosou.de/locatons/noosou-hannover-bemerode-asian-fresh-kitchen/ | +49 511 39080803 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Nordsee | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | L/A | https://www.nordsee.com/de/ | +49 511 363890 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Olav's Kitchen by Möbelhaus Staude | 30165 | ITALIAN | WEBSHOP,PHONE | -/A | https://olavs-kitchen.de/ | +49 511 9379842 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ong Tao | 30451 | VIETNAMESE | WEBSHOP,PICKUP,PHONE | -/A | https://www.ongtao.net/ | +495114500575 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Outbax Spirit | 30655 | OTHER | WEBSHOP,PHONE | -/A | https://www.outbaxspirit.de/ | +49511578251 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Palladion | 30559 | GREEK | WEBSHOP,PHONE | -/A | https://palladion-hannover.de | +49 511 526923 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Panover | 30159 | AMERICAN | WEBSHOP,PHONE | L/- | https://www.pan-over.de/ | +49 511 79028718 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Panu Pizza & Panuozzo | 30161 | PIZZA | WEBSHOP,PHONE | -/A | https://panu-pizza.de/ | +49 511 54442942 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pera | 30161 | ITALIAN | WEBSHOP,PHONE | -/A | https://cafepera.eatbu.com/ | +49 511 344934 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Peter Pane | 30159 | BURGER | WEBSHOP,PICKUP,PHONE | L/A | https://peterpane.de/standorte/#!/l/hannover/lange-laube-6/3087001 | +49 511 33646469 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pfannkuchenhaus | 30169 | OTHER | WEBSHOP,PHONE | -/A | https://www.pfannkuchenhaus.de/ | +4951117113 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pfefferkorn | 30163 | OTHER | WEBSHOP,PHONE | -/A | https://www.pfefferkornhannover.de | +49 511 660889 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Phamy Sushi | 30453 | ASIAN,CHINESE,SUSHI,THAI | WEBSHOP,PHONE | -/A | https://www.phamysushihannover.de/ | +49 511 35365688;+49 511 35365689 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Piazza Italiana Trattoria & Artisan Pizza | - | PIZZA | WEBSHOP,PHONE | -/A | https://lapiazzaitaliana.com/ | +49 511 21906239 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pier 51 | 30173 | OTHER | WEBSHOP,PHONE | -/A | https://www.pier51.de/ | +49 511 8071800 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza 96 | 30419 | PIZZA | WEBSHOP,PHONE | -/A | https://www.pizzeria96.de/ | +49 511 76363234 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Eat me | 30657 | PIZZA,ITALIAN,INDIAN | WEBSHOP,PHONE | L/A | https://pizzaeatme.de/ | +49 511 90883030 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Frischdienst | - | ITALIAN | WEBSHOP,PICKUP | -/A | https://www.pizza-frischdienst-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Garten  Hannover | 30453 | PIZZA | WEBSHOP | L/- | https://www.pizzagartenhannover.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Grande | 30159 | PIZZA | WEBSHOP,PHONE | L/A | https://pizza-grande.net/ | +49 511 16921200 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Hannover | 30173 | BURGER,GREEK,ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | http://www.pizzeriahannover.de/ | +49 0511888488 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Haus | 30629 | ITALIAN,PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://www.haus-pizza.de | +49 511 5865555 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Hut | - | PIZZA | WEBSHOP,PHONE | L/- | https://pizzahut.de/de/store-locator/pizza_hut_hannover_hauptbahnhof | +49 157 862 510 50 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Lust | 30559 | PIZZA | WEBSHOP,PHONE | L/- | https://www.pizza-lust-hannover.de/ | +49 511 62666522 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Night | - | PIZZA | WEBSHOP,PHONE | L/- | https://www.pizzeria-night.de/ | 05113507610 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Number One | - | PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://www.pizzanumberonehannover.de | +4951135385353 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Pazza - da Leo | 30539 | ITALIAN,PIZZA | WEBSHOP,PICKUP,PHONE | L/A | https://pizzapazza.de/ | +49 511 5179394 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizza Punks | 30451 | PIZZA | WEBSHOP,PHONE | L/A | https://pizza-punks-hannover.order.app.hd.digital/ | +49 051189938871 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Service Hannover Vital | 30449 | PIZZA | WEBSHOP,PHONE | -/A | https://www.vital-pizza-hannover.de/ | +49 511 454102 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Slice | 30167 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://www.pizzaslice-hannover.de/ | +49 051137021472 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Tornado Misburg | 30629 | PIZZA,BURGER,ITALIAN | WEBSHOP,PHONE,PICKUP | L/A | https://www.tornadopizza.de/filialen/misburg | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Ustad | 30453 | PIZZA | WEBSHOP,PHONE | L/A | https://www.pizzaustad.de/ | +49 511 35736668 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizzamax | 30163 | PIZZA | WEBSHOP,PHONE | L/- | https://www.pizzamax.de/hannover/ | +4951190887799 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizzeria Aroma (Pizza Roma) | 30453 | PIZZA,ITALIAN,DOENER | WEBSHOP,PHONE,PICKUP | L/A | https://www.pizzaroma-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizzeria Malbat | - | ITALIAN | WEBSHOP,PICKUP,PHONE | L/A | https://www.pizzeriamalbat.de | +49 5101 9913400 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pizzeria Today | 30559 | PIZZA,ITALIAN | WEBSHOP,PHONE | L/A | https://www.pizzeriatoday.de/ | +49 511 9585808 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Play Off | - | AMERICAN,BURGER | WEBSHOP,PHONE | -/A | https://www.play-off-hannover.de/ | +495115684990 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pommes-Helden | 30159 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://pommes-helden.de | +49 511 36010 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Radieschen | - | OTHER | WEBSHOP,PHONE | -/A | https://restaurant-radieschen.de/ | +49 511 2155261 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Raffaele's | - | ITALIAN | WEBSHOP,PHONE | -/A | https://www.raffaeles-hannover.de | +491784905629 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Rasoi | - | INDIAN | WEBSHOP,PHONE | -/A | https://rasoi-hannover.de/ | +49 511 693343 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Reimanns Eck | 30161 | OTHER | WEBSHOP,PHONE | -/A | https://www.reimanns-eck.de | +49 511 313530 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant Marie | - | OTHER | WEBSHOP,PHONE | -/A | https://www.restaurantmarie.de | +49 511 65399074 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant Ofelia | 30419 | GREEK | WEBSHOP,PHONE | L/A | https://restaurant-ofelia.de/ | +49 511 44454926 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Vienna | 30175 | OTHER | WEBSHOP,PHONE | -/A | https://www.vienna-restaurant.de/ | +49 511 27900777 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurante Fellini | 30161 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.ristorante-fellini.de/ | +49 511 623760 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Retro Calenberger Landterrassen | 30457 | OTHER | WEBSHOP,PHONE | -/A | https://www.restaurant-retro.net | +49 511 47302787 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | RIAS BAIXAS 2 | 30449 | OTHER | WEBSHOP,PHONE | -/A | https://www.riasbaixas-2.de | +49 511 1234 209 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Richards | - | OTHER | WEBSHOP,PHONE | -/A | https://richards-restaurant.de/ | +49 51378749060 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ricklinger Gasthaus Anno 1901 | 30459 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://www.anno1901-ricklingen.de/ | +49 511 420079 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | River Boat | - | OTHER | WEBSHOP,PHONE | -/A | https://river-boat.eatbu.com/ | +49 511 8984439 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | RiX | 30459 | OTHER | WEBSHOP,PHONE | -/A | https://www.schnitzel-paradies.de/ | +49 511 64719014 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Rüpel | 30451 | OTHER | WEBSHOP,PHONE | -/A | https://www.ruepel.bar/ | +%2049%20(0)%20172%20158%20675%202 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Saigon | 30171 | VIETNAMESE | WEBSHOP,PHONE | -/A | https://saigon-hannover.de/ | +49 511 37356019 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | San Marino | 30161 | ITALIAN | WEBSHOP | L/- | https://www.pizzeria-sanmarino.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sapori Italiani | 30519 | ITALIAN,PIZZA | WEBSHOP,PICKUP,PHONE | -/A | https://saporiitaliani-hannover.de | +49 511 89911124 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Say Cheese! | 30459 | PIZZA | WEBSHOP,PHONE | L/- | https://www.pizza-saycheese.de | +49 511 41047777 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Schnitzery | 30161 | OTHER | WEBSHOP | -/A | https://schnitzery.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Schorse im Leineschloss | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://schorse-im-leineschloss.de | +49 511 30302411 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Schützenhaus Kaltenweide Da Salvo | - | OTHER | WEBSHOP,PHONE | -/A | https://www.schuetzenverein-kaltenweide.de/ | +49 511 774202 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sen Pizza Nudel Express | 30625 | DOENER,ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | http://senpizza.de/ | +49 0511550700 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Shalimar | 30159 | INDIAN | WEBSHOP,PICKUP,PHONE | -/A | https://www.shalimar-hannover.de/ | +49 511 14848 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Shinebar | - | OTHER | WEBSHOP,PHONE | -/A | https://www.shinebar.de/ | +49 511 70030177 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Siam Thai Restaurant | 30165 | THAI | WEBSHOP,PHONE | -/A | https://www.siam-thai-restaurant.de/ | +49 511 84902394 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Silbervogel | 30453 | GREEK | WEBSHOP,PHONE | -/A | https://cafe-restaurant-silbervogel.eatbu.com/ | +49 511 4104960 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sissi und Franz | - | BURGER | WEBSHOP,PICKUP,PHONE | -/A | https://www.sissiundfranz.eu/hannover/ | +4951164726090 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Smoking Bianco | 30167 | ITALIAN,PIZZA | WEBSHOP,PHONE | -/A | https://smokingbianco.de | +49 511 67913166 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Star Kebap | 30419 | DOENER,TURKISH,PIZZA,BURGER | WEBSHOP,PHONE,PICKUP | L/A | https://www.starkebap-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Steakhaus Kampe | 30659 | OTHER | WEBSHOP,PHONE | -/A | https://steakhouse-kampe.de | +49 511 6405171 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Steuerndieb | 30655 | OTHER | WEBSHOP,PICKUP,PHONE | -/A | https://www.steuerndieb.de/ | +49 511 909960 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Street Kitchen - Viet Cuisine | 30451 | VIETNAMESE | WEBSHOP,PHONE | L/A | https://streetkitchen-viet-cuisine-hannover.de/ | +49 511 98638834 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ständige Vertretung | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://staev-hannover.de/ | +49 511 2138690 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sultan Kebap Hannover | - | DOENER,TURKISH,PIZZA,BURGER | WEBSHOP,PHONE,PICKUP | L/A | https://www.sultankebaphannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Supperclub34 | 30161 | OTHER | WEBSHOP,PHONE | -/A | https://supperclub34.de/ | +49 511 4953 1090 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sushi Kaiser | - | SUSHI | WEBSHOP | -/A | https://www.sushikaiser.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sushi Mix Hannover | 30449 | SUSHI,ASIAN | WEBSHOP,PICKUP | -/A | https://sushimixhannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sushifreunde | 30171 | SUSHI | WEBSHOP,PICKUP,PHONE | -/A | https://www.ai-sushi.de/ | +49 511 89989994 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | TAI PAI | 30169 | CHINESE | WEBSHOP,PHONE | -/A | https://www.tai-pai.de/ | +49 511 885230 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Tandoori Haus | 30177 | INDIAN | WEBSHOP,PHONE | -/A | https://india-tandoori-haus.de/ | +49 511 80761717 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Taste of India | - | INDIAN | WEBSHOP | -/A | https://www.taste-of-india-hannover.de | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Taverna Asteria | 30163 | GREEK | WEBSHOP,PHONE | -/A | https://www.tavernaasteria.de/ | +49 511 90882723 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Taverne Nikala | 30159 | OTHER | WEBSHOP,PHONE | L/A | https://www.tavernenikala.de/ | +49 157 33228300 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Teichhûs | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.teichhues.de/ | +49 511 89714893 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | The living - room - | - | OTHER | WEBSHOP,PHONE | -/A | https://theliving.eu/ | +49 511 600 33 981 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | The Pizza Factory | 30167 | PIZZA | WEBSHOP,PICKUP,PHONE | L/A | http://www.thepizzafactory.de/ | +49 511 3507000 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Thessaloniki | 30165 | GREEK | WEBSHOP,PHONE | L/A | https://thessaloniki-hanover.edan.io | +49 05113506461 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | TOB-Restaurant | 30179 | OTHER | WEBSHOP,PHONE | -/A | https://www.tob-restaurant.com/ | +49 511 47316900 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Toscanini | 30169 | ITALIAN | WEBSHOP,PHONE | -/A | https://toscanini-hannover.de/ | +49 511 71227711 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Trattoria Ecco | 30171 | ITALIAN | WEBSHOP,PHONE | L/A | https://trattoria-ecco.eatbu.com/ | +49 511 70819235 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Trattoria il Padrino | 30659 | ITALIAN | WEBSHOP,PHONE | -/A | https://www.trattoria-il-padrino.de | +49 511 59206147 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Trattoria Massimo | 30559 | ITALIAN,PIZZA | WEBSHOP,PHONE | L/A | https://trattoria-massimo.de/ | +49 511 528092 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Urfa Deluxe Holzkohlegrill | 30459 | TURKISH | WEBSHOP,PICKUP,PHONE | -/A | https://urfadeluxe.de | +49 511 21597010 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Va Bene | 30175 | ITALIAN,PIZZA | WEBSHOP,PHONE | -/A | https://va-bene-hannover.de/ | +49511812362 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Valentino | - | ITALIAN | WEBSHOP,PHONE | -/A | https://www.kgv-flora.de/vereinsheim | +49 176 21426137 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Vegan Village | 30169 | ASIAN | WEBSHOP,PHONE | -/A | https://vegan-village.com/ | +49 511 10534296 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Vereinsgaststätte des TuS Vahrenwald 08 | 30179 | OTHER | WEBSHOP,PHONE | -/A | https://tus-vahrenwald.de/unser-verein/vereinsgaststaette/ | +49 511635494 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Vereinsgaststätte TSV Fortuna Sachsenross | - | ITALIAN | WEBSHOP | -/A | https://www.tsvfortuna.de/clubgaststaette/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Vier Jahreszeiten | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.restaurant-vierjahreszeiten.de/ | +49 511 841212 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Viet Nam | 30173 | VIETNAMESE,ASIAN | WEBSHOP,PHONE | L/A | https://www.vietnam-hannover.de/ | +49 05113363769 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Vietal-Kitchen | 30161 | VIETNAMESE | WEBSHOP,PHONE | -/A | https://vietal-kitchen.de/hannover/ | +49 511 38877888 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Vince Trattoria | 30173 | ITALIAN | WEBSHOP,PHONE | -/A | https://vince-trattoria.de/ | +49 511 23582164 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Voi | 30159 | ASIAN,ITALIAN | WEBSHOP,PHONE | -/A | https://voi-hannover.de/ | +49 511 54685560 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Wirtshaus Wülfel | 30519 | OTHER | WEBSHOP,PHONE | -/A | https://www.wirtshaus-wuelfel.de | +49 511 16270854 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Wrapper | 30167 | TURKISH | WEBSHOP,PHONE | -/A | https://wrapper-hannover.de/ | +4951164713594 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Your Pizza Express | - | PIZZA | WEBSHOP,PHONE | L/- | https://www.yourpizza-express.de | +49 511 77955855 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | ZEUS Griechisches Restaurant | 30657 | GREEK | WEBSHOP | -/A | https://zeus-hannover.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Zum Kamin | 30159 | OTHER | WEBSHOP,PHONE | -/A | https://www.zumkamin-hannover.de/ | +49 511 320426 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Zur Eiche | 30455 | OTHER | WEBSHOP,PHONE | L/A | https://zur-eiche-cafe-bar.9gg.de | +49 0511490525 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Öz Antalya Kebap | 30459 | TURKISH | WEBSHOP,PHONE | -/A | https://www.oez-antalya.de/ | +49 511 2347801 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | ÖZ URFA 63 | - | DOENER,TURKISH | WEBSHOP,PICKUP | L/A | https://soez-urfa-63.eatbu.com/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | #DreiEck | - | BURGER,ITALIAN,PIZZA | PHONE,PICKUP | -/A | - | +49 511 67919837 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | 6 Sinne | 30159 | OTHER | PHONE,PICKUP | -/A | https://www.6sinne-hannover.de/ | +49 511 47388038 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | 993 Restaurant & Bar | 30173 | OTHER | PHONE,PICKUP | -/A | https://993-hannover.de/ | +49 511 56377742 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | [hof:geflüster] | - | OTHER | PHONE,PICKUP | -/A | http://hofgeflüster.com/ | +49 511 80606630 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Acht & Siebzig | 30169 | OTHER | PHONE,PICKUP | -/A | https://www.achtundsiebzig.de/ | +49 051194020922 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Adam's Kitchen | 30657 | BURGER,ITALIAN,PIZZA | PHONE,PICKUP | -/A | https://www.adamskitchen.de/ | +49 511 89829576 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Adesso | 30163 | ITALIAN | PHONE,PICKUP | -/A | https://adesso-feinkost.de/index.php/start/ | +49 511 54545342 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Adraitic | - | OTHER | - | -/- | https://adriatic-hotel.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Adrian Pizzeria | 30167 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | - | +49 511 89821638 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Alanya | 30659 | TURKISH | PHONE,PICKUP | -/A | http://alanya-restaurant.de/ | +49 511 69097935 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Alexander | 30159 | OTHER | PHONE | -/A | https://www.alexander-hannover.de/ | +49 511 325826 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Alioli | 30559 | OTHER | PHONE | -/A | https://spanier-hannover.de/ | +49 511 37369300 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | All Vegan | 30159 | OTHER | PHONE,PICKUP | -/A | - | +49 511 21344769 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Alsham | 30159 | OTHER | PHONE,PICKUP | -/A | - | +49 176 40568760 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Alte Hahnenburg | 30559 | OTHER | PHONE | -/A | https://www.alte-hahnenburg.com | +49 511 526200 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Alter Bahnhof Anderten | 30559 | OTHER | PHONE | -/A | https://www.alter-bahnhof-anderten.de | +49 511 591710 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Amici miei | 30161 | ITALIAN | PHONE,PICKUP | -/A | https://amici-miei.de | +49 511 343829 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Antonella | 30163 | ITALIAN | PHONE,PICKUP | -/A | - | +49 511 80762722 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Aram Kebab Haus | - | DOENER | - | -/- | https://aram-kebab-haus.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Aristoteles | 30165 | GREEK | PHONE,PICKUP | -/A | http://www.aristoteles-hannover.de/ | +49 511 3482141 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Artemis | 30451 | GREEK | - | -/- | https://artemis-restaurant-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Artinos | 30627 | GREEK | PHONE,PICKUP | -/A | http://www.artinos-hannover.de/ | +49 511 80604345 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Bistro Thanh An | 30179 | ASIAN | - | -/- | http://thanhan.gruetze.eu | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Food Hannover | 30159 | ASIAN,SUSHI,THAI,VIETNAMESE | PHONE,PICKUP | -/A | https://asiafood-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Imbiss Kok | - | ASIAN | PHONE,PICKUP | -/A | - | +49 511 47380820 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Asia Regent | - | ASIAN | - | -/- | https://www.asia-regent.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Aspera | 30161 | TURKISH | PHONE,PICKUP | -/A | https://aspera-restaurant-hannover.de/ | +49 051189849810 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Atlantis | 30419 | GREEK,ITALIAN | PHONE,PICKUP | -/A | https://www.atlantis-hannover.de | +49 511 753570 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Atrium | 30159 | OTHER | PHONE,PICKUP | -/A | https://www.altes-rathaus-hannover.de/ | +49 511 3008040 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | A´Mura | 30159 | ITALIAN | PHONE | -/A | https://www.a-mura.de/ | +49 511 328665 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bab al Yemen | 30159 | OTHER | - | -/- | https://bab-al-yemen-modern.de/speisekarte/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Baba | 30657 | DOENER | - | -/- | https://restaurant-baba.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Baba Mia | 30159 | BURGER | PHONE,PICKUP | -/A | https://babamia.de | +49 511 60499924 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Bahnhof Leinhausen | 30419 | OTHER | PHONE | -/A | https://www.bahnhof-leinhausen.de/ | +495112794900 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bambus Garden | - | CHINESE | PHONE | -/A | https://www.bambus-garden-kirchrode.de/ | +49 511 80 69 083 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Basil | 30163 | OTHER | PHONE | -/A | https://www.basil.de/ | +49 511 622636 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bavarium | 30159 | OTHER | PHONE,PICKUP | -/A | http://www.bavarium.de | +49 511 323600 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Beckmann's Restaurant & Weinhaus | - | ITALIAN | PHONE | -/A | https://www.beckmanns-weinhaus.de/ | +495111316891 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bei Amou | 30559 | GREEK | PHONE,PICKUP | -/A | - | +49 0511523872 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Bei Mario | - | PIZZA,ITALIAN | PHONE,PICKUP | -/A | https://beimario-listerdamm.de/ | +49 511 631412 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Beiwi | 30165 | CHINESE | PHONE,PICKUP | -/A | http://www.beiwi-buffet.de | +49 511 89943710 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Benatis | - | OTHER | - | -/- | https://www.sc-schwarz-gold.de/vereinsheim.html | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Bistro Classico | - | ITALIAN | - | -/- | https://www.sportcenter-empelde.de/bistro-classico | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Bistro Da Toni | 30163 | ITALIAN | PHONE,PICKUP | -/A | https://www.bistrodatoni.de/ | +49 511 5906990 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | BLOCK HOUSE | 30159 | OTHER | PHONE | -/A | https://www.block-house.de/restaurants/hannover/am-kroepcke/ | +49 511 32 12 39 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Bohoo | 30167 | OTHER | PHONE,PICKUP | -/A | https://cafebohoo.de/ | +49 511 79095018 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | bona'me | 30159 | TURKISH,OTHER | PHONE,PICKUP | -/A | https://bona-me.de/hannover-boname/ | +49 511 12376880 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Brasserie Rendezvous | 30659 | OTHER | PHONE,PICKUP | -/A | - | +49 511 6404330 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Brauereigaststätte Wienecke XI. | 30519 | OTHER | PHONE,PICKUP | -/A | https://www.wienecke.de | +49 511 12611536 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Brela | 30625 | OTHER | PHONE,PICKUP | -/A | https://restaurant-brela.de/ | +49 511 576151 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Brudis | 30161 | BURGER,DOENER | - | -/- | https://brudis-db.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Bull's Kitchen | 30159 | BURGER | PHONE | -/A | https://www.bullskitchen.de/ | +49 511 21900990 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Burgerimbiss Hannover | 30453 | BURGER,OTHER | - | -/- | https://www.burgerimbiss-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Busan Chicken | 30159 | OTHER | PHONE | -/A | https://www.busan-chicken.de | +49 511 94033217 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Butschies Bistro am Maschsee | 30169 | OTHER | PHONE,PICKUP | -/A | https://butschies-bistro.de/hannover-maschsee/bistro/ | +49 5066900440 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Cafe & Bar Celona | 30159 | BURGER | PHONE | -/A | https://celona.de/cafe-bar-celona-hannover-altstadt | +49 511 3538576 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Cafe Steintormasch | 30167 | OTHER | PHONE,PICKUP | -/A | https://steintormasch-cafe.de/ | +49 511 7000717 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Café Kifaru | 30175 | BURGER,PIZZA | PHONE | -/A | https://www.zoo-hannover.de/location-kifaru | +49 511 28074163 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Café und Bistro Kastagnette | 30519 | OTHER | PHONE,PICKUP | -/A | - | +49 511 87807844 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Café&Restaurant Korthaus | 30519 | OTHER | PHONE | -/A | https://www.cafe-korthaus.de/ | +49 511 863146 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Cape Town | 30159 | OTHER | PHONE,PICKUP | -/A | - | +49 511 35303555 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Cham | 30161 | ASIAN,OTHER | PHONE,PICKUP | -/A | https://chamthevegankitchen.de/chamhannover | +49 511 21950700 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Changan Noodle House | - | CHINESE,ASIAN | PHONE,PICKUP | -/A | - | +49 511 71300026 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Cheers | 30167 | OTHER | PHONE,PICKUP | -/A | http://www.cheers-hannover.de/ | +49 511 13461 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Chicago's | - | OTHER | PHONE | -/A | https://chicagos.de/ | +49 511 12347061 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | China Dim Sum House | 30159 | CHINESE | PHONE,PICKUP | -/A | https://www.dim-sum-hannover.de/ | +49 511 89824088 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | China Restaurant Panda | 30659 | CHINESE,ASIAN | PHONE,PICKUP | L/A | https://panda-hannover.de | +49 511 8980782 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | China-Imbiss-Jasmin | 30459 | ASIAN,CHINESE | PHONE,PICKUP | -/A | https://china-imbiss-jasmin-1.jimdosite.com/ | +49 511 2349870 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Chois | 30161 | ASIAN | - | -/- | https://www.restaurant-chois.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Clubwirt | 30453 | OTHER | PHONE,PICKUP | -/A | https://www.victoria-linden.de/Clubwirt.aspx | +49 151 54117650 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Coimbra | - | OTHER | PHONE,PICKUP | -/A | https://www.coimbra-hannover.de/ | +49 511 451858 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Crunchy snacks & more | 30169 | OTHER | PHONE,PICKUP | -/A | https://www.crunchy-hannover.de/ | +49 511 44455952 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Crêperie | 30451 | OTHER | PHONE,PICKUP | -/A | - | +49 511 51514484 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Culinar | 30419 | OTHER | PHONE,PICKUP | -/A | https://www.mtv-herrenhausen.de/vereinsheim | +49 511 53942084 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Curry Leaves | 30177 | INDIAN | PHONE,PICKUP | -/A | https://curryleavesrestaurant.de/ | +49 511 37024512 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Da Andrea | 30175 | ITALIAN | PHONE,PICKUP | -/A | https://da-andrea.jimdo.com/ | +49 511 282224 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Damar Baba Döner | - | DOENER | PHONE,PICKUP | -/A | https://damarbabadoner.com/ | +49 163 3516983 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Damn Dog | 30159 | AMERICAN | - | -/- | https://damn-dog.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Daniel's | 30161 | OTHER | PHONE,PICKUP | -/A | https://restaurantdaniels.de/ | +49 511 3362948 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Das Ding | 30163 | BURGER | PHONE | -/A | https://www.dasding-restaurant.de | +49 511 392999 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Das Nest | 30625 | OTHER | PHONE,PICKUP | -/A | https://dasnest-hannover.de/ | +49 051137391271 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Das Vikings | 30539 | OTHER | PHONE,PICKUP | -/A | https://www.das-vikings.de/ | +49 015201917571 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Die EinBURGERung | 30629 | AMERICAN,BURGER | PHONE,PICKUP | -/A | - | +49 152 15321374 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Dionysos | - | GREEK | PHONE,PICKUP | -/A | - | +49 511 736333 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Doli | 30163 | OTHER | PHONE,PICKUP | -/A | https://doli.restaurant | +49 176 12223377 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Donatos Der Imbiss | - | OTHER | - | -/- | http://www.donatos-der-imbiss.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Döner Chef | 30179 | DOENER | PHONE,PICKUP | -/A | - | +49 511 72727942 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Döner Lisa | 30169 | DOENER | PHONE,PICKUP | -/A | - | +49 155 60300255 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Dönerium 2 Ronnenberg | - | DOENER | PHONE,PICKUP | -/A | - | +49 51092692427 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Eckis Wirtshaus | 30449 | OTHER | PHONE | -/A | https://eckiswirts.haus/ | 017683189901 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Edessa Gemüsekebap | 30177 | DOENER | PHONE,PICKUP | -/A | - | +49 511 47399000 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | El Chileno | 30657 | OTHER | PHONE,PICKUP | -/A | https://www.el-chileno.de/ | +49 051190882677 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | El Pais | 30161 | OTHER | PHONE,PICKUP | -/A | https://elpais-tapasbar.de/ | +49 511 313115 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | El Paso | - | MEXICAN | PHONE | -/A | https://www.el-paso.restaurant/ | +49 51140089477 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Elena | 30459 | GREEK | PHONE,PICKUP | -/A | - | +49 0511429151 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Elia | 30167 | GREEK | PHONE,PICKUP | -/A | - | +49 01797296267 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Elim Hotpot | 30519 | CHINESE | PHONE,PICKUP | -/A | https://www.elimrestaurant.de/ | +49 511 8988920 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Eliniko | 30171 | GREEK | PICKUP,PHONE | -/A | https://www.eliniko-hannover.de/ | +49 511 81 76 00 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Esskult | 30519 | OTHER | PHONE,PICKUP | -/A | - | +49 511 76086985 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Esskultur | - | OTHER | - | -/- | https://hannover.meandallhotels.com/esskultur | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Esty's Taste | 30163 | OTHER | PHONE,PICKUP | -/A | https://estystaste.com/ | +49 160 92852885 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Euphrat | 30655 | GREEK | PHONE,PICKUP | -/A | http://www.euphrat-hannover.de | +49 511 621307 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Fairuz Grill | - | OTHER | PHONE,PICKUP | -/A | - | +49 511 59208025 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Falafel Sultan | 30451 | DOENER,TURKISH | PHONE,PICKUP | -/A | - | +49 051137357554 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Familienrestaurant Smak | - | OTHER | PHONE,PICKUP | -/A | https://www.smak-restaurant.de/ | +49 511 98427633 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Felicita | 30451 | ITALIAN | PHONE,PICKUP | -/A | - | +49 051145003611 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Finca Hannover | 30169 | OTHER | PHONE | -/A | https://www.finca-hannover.de/ | +49 511 1319999 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Fischers | 30451 | MEXICAN | PHONE,PICKUP | -/A | https://www.estrella-gastro.de/fischers-linden.html | +49 511 441404 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | FoodBreak20 | - | OTHER | PHONE | -/A | https://de.dussmann.de/foodbreak20 | +4951147312390 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Frittenbox | 30159 | OTHER | PHONE,PICKUP | -/A | - | +49 511 53073548 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Frittenwerk | 30159 | OTHER | PICKUP,PHONE | -/A | https://frittenwerk.com/hannover.php | +49 511 21341130 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Frytastic | 30451 | BURGER | PHONE,PICKUP | -/A | - | +49 151 20755995 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Funky Kitchen | - | OTHER | - | -/- | https://funky.kitchen/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gallo Nero | 30655 | ITALIAN | PHONE,PICKUP | -/A | https://www.gallo-nero-hannover.com/ | +49 511 5463434 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gaststätte am Annateich | 30625 | OTHER | PHONE,PICKUP | -/A | https://annateich.de | +49 511 53327623 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gaststätte Kaiser | - | OTHER | - | -/- | https://www.gaststaette-kaiser.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Georgen Terrassen | 30167 | OTHER | PHONE,PICKUP | -/A | https://georgen-terrassen.de/ | +49 511 26295424 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gerstenkorn | 30171 | OTHER | PHONE,PICKUP | -/A | https://www.restaurant-gerstenkorn.de/ | +49 511 281620 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Goldener Drache | - | CHINESE | PHONE,PICKUP | -/A | - | +49 511 3748104 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Gondel | 30159 | OTHER | PHONE,PICKUP | -/A | https://www.restaurant-gondel.de/ | +49 511 30186710 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Griechische Spezialitäten Christos | - | GREEK | - | -/- | https://www.greekkitchen-ellada.de/griechisches-restaurant-christos-im-zimmermann-in-hannover-junkersstrasse-1/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | grüpchen | 30159 | OTHER | PHONE,PICKUP | -/A | https://hotel-an-der-marktkirche.de/grupchen/ | +49 511 368640 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Güney Urfa Kebab Haus | 30559 | DOENER,TURKISH | PHONE,PICKUP | -/A | - | +49 511 54442585 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | H'Vin | 30657 | OTHER | PHONE,PICKUP | -/A | https://hvin.de/ | +49 511 6045222 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Hamachi | - | SUSHI | PHONE,PICKUP | -/A | https://www.hamachihannover.de/ | +49 511 37356120 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Handwerk | 30173 | OTHER | PHONE | -/A | https://handwerk-hannover.com/ | +49 511 26267588 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Hannoi Bites 87 | 30167 | VIETNAMESE | PHONE,PICKUP | -/A | https:/www.hannoibites87.de | +49 511 89852222 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Hans im Glück | 30159 | BURGER | PHONE | -/A | https://hansimglueck-burgergrill.de/burger-restaurant/hannover-limhof/ | +49 511 27789677 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Happy Fries | - | OTHER | - | -/- | https://www.happyfries.nl/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Havn Bar und Restaurant | 30163 | SUSHI | PHONE | -/A | https://havn-hannover.de | +49 511 16653107 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | HUONG | - | ASIAN,CHINESE,SUSHI,VIETNAMESE | PHONE,PICKUP | -/A | - | +49 511 26232377 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Högers 1910 | 30171 | OTHER | PHONE,PICKUP | -/A | http://hoegers1910.de | +49 511 5106425 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ichiban | 30159 | SUSHI | PHONE,PICKUP | -/A | https://mrphung.de/ichiban-hannover/ | +49 511 2157609 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | ICKE BIN's Gemüsekebap | 30451 | DOENER,TURKISH,OTHER | PHONE,PICKUP | -/A | - | +49 163 4817778 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Idol Kebab Haus | 30171 | DOENER | - | -/- | http://www.ido-kebap.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | il piccolo nero | 30451 | ITALIAN | PHONE,PICKUP | -/A | https://www.ilpiccolonero.de/ | +49 511 5391232 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ilion | 30173 | GREEK | PHONE,PICKUP | -/A | https://www.restaurant-ilion.de/ | +49 511 814728 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Incili Kö | 30165 | TURKISH | PHONE,PICKUP | -/A | - | +49 511 59106219 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ischia | 30629 | ITALIAN | PHONE | -/A | https://www.restaurant-ischia-misburg.de/ | +49 511 588210 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Istanbul Kebap | 30451 | DOENER | PHONE,PICKUP | -/A | - | +49 511 519340 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Istanbul Ocakbasi | 30179 | DOENER,TURKISH | PHONE | -/A | https://www.istanbul-vahrenheide.de/ | +49 511 72737494 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Jante | 30171 | OTHER | PHONE,PICKUP | -/A | https://www.jante-restaurant.de/ | +49 511 54555606 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Jung-Gu | 30167 | ASIAN | PHONE,PICKUP | L/A | https://jung-gu.de/ | +49 511 60498344 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kebapci Musa | - | DOENER | PHONE,PICKUP | -/A | - | +49 511 35778190 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | KING HAUS | 30455 | BURGER,DOENER,PIZZA | PHONE,PICKUP | -/A | - | +49 511 54612059 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kleefelder Stübchen | 30625 | OTHER | PHONE,PICKUP | -/A | - | +49 176 63307171 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Kleefood | - | BURGER,PIZZA | - | -/- | https://kleefood.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Koh-I-Noor Dhaba | 30169 | INDIAN | PHONE | -/A | https://www.kohinoor-hannover.de/ | +49 511 95483483 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Kröner | 30539 | DOENER | PHONE,PICKUP | -/A | https://www.wenndönerdannkröner.de | +49 511 22014903 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | KUHnstwerk | 30159 | BURGER | PHONE,PICKUP | -/A | - | +49 511 35344522 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | König Café Restaurant Bar | - | OTHER | - | -/- | https://www.konig-restaurant-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | L'Osteria | 30179 | ITALIAN | PHONE,PICKUP | L/A | https://losteria.net/de/restaurants/restaurant/hannover-vahrenwalder/ | +49 511 67696737 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Barca | 30419 | PIZZA | PHONE,PICKUP | -/A | - | +49 051151999925 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Bonita | 30175 | MEXICAN | PHONE,PICKUP | -/A | - | +49 511 94040788 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Buca | 30165 | ITALIAN | PHONE | -/A | https://www.labuca.de/ | +49 511 36587001 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Cantina | 30161 | OTHER | PHONE,PICKUP | -/A | http://tapasparadies.eu/ | +49 511 3880210 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Forchetta | 30173 | ITALIAN | PHONE | -/A | https://www.forchetta-hannover.de/ | +49 511 8503808 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Laterna | 30161 | PIZZA | PHONE,PICKUP | -/A | - | +49 511 331129 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Lucania II | 30173 | PIZZA | PICKUP,PHONE | -/A | https://www.la-lucania2.de | +49 511 22899995 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | La Paella | 30177 | OTHER | PHONE,PICKUP | -/A | http://www.lapaella.de/ | +49 511 392936 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | La Vida | 30161 | OTHER | PHONE,PICKUP | -/A | https://lavida-restaurant.de/ | +49 511 35363568 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Land of Pizza | 30419 | BURGER,PIZZA | PHONE | -/A | https://speisekartenweb.de/restaurants/hannover/land-of-pizza-2-158759#section-speisekarte | +49 511 37497900 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lazio | 30455 | PIZZA | PHONE,PICKUP | -/A | https://www.pizza-lazio-hannover.de | +49 511 494043 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lehaha | 30519 | CHINESE | PHONE,PICKUP | -/A | http://www.restaurant-lehaha.de/ | +49 511 56968858 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Leinegold | 30175 | OTHER | PHONE,PICKUP | -/A | https://www.leinegold.com/ | +49 511 3889654 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Levante | 30659 | OTHER | PHONE | -/A | http://www.levante-hannover.de/ | +49 511 9055932 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lieblingsbar | 30419 | OTHER | PHONE | -/A | https://lieblingsbar.de/ | +49 511 76809126 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lieblingsessen | - | ITALIAN,PIZZA | PHONE,PICKUP | -/A | - | +49 51314420800 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Limmehr | 30453 | OTHER | PHONE,PICKUP | -/A | https://www.limmehr.de/ | +49 511 211155 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Limmer Döner | - | DOENER,TURKISH | PHONE,PICKUP | -/A | - | +49 511 54300355 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lindenblatt 800 Â° | 30159 | OTHER | PHONE,PICKUP | -/A | - | +49 511 12367734 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lindener Bergterrasse | 30449 | GRILL,ITALIAN | PHONE | -/A | https://lindener-bergterrassen.eatbu.com/?lang=de | +491734322327 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Lister Döner (Prinz) | 30161 | DOENER,TURKISH,GRILL | PHONE,PICKUP | -/A | https://listerdoener.de/ | +49 511 21912566 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lorberg | 30451 | OTHER | PHONE,PICKUP | -/A | - | +49 511 2106867 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Loretta's | 30169 | OTHER | PHONE,PICKUP | -/A | http://www.lorettas-hannover.de/ | +49 511 5905780 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | LSV Alexandria Gaststätte | 30459 | OTHER | - | -/- | https://alex1903.de/index.php/gastronomie/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lucht's Grill | 30177 | OTHER | PHONE,PICKUP | -/A | http://www.luchts-grill.de/Home | +49 511 695365 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Luci della Montagna | 30449 | ITALIAN | PHONE,PICKUP | -/A | - | +49 05114583745 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Lukullus | 30453 | GREEK | PHONE | -/A | https://www.lukullus-hannover.de | +49 511 482471 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mahlzeit Imbiss | - | BURGER,DOENER,PIZZA | PHONE,PICKUP | -/A | - | +49 177 6247245 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Malatya Grill | 30625 | TURKISH | PHONE,PICKUP | -/A | https://malatyagrill.de/ | +49 05115547605 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mangal's Kitchen | 30163 | INDIAN | PHONE,PICKUP | -/A | https://restaurant-mangals-kitchen.de/ | +49 511 64693150 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Manti love | 30159 | TURKISH | - | -/- | https://www.mantilove.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Marijas Nudelparadies | 30177 | ITALIAN | PHONE | L/- | https://marijasnudelparadies.com/ | +49 511 623285 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Marâa Beef Club | - | OTHER | PHONE,PICKUP | -/A | https://bogabeef.de | +49 176 70238862 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Meiers Lebenslust | 30159 | OTHER | PHONE,PICKUP | -/A | https://www.meiers-lebenslust.de/ | +49 511 8982250 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mel's Diner | - | AMERICAN | PHONE,PICKUP | -/A | https://www.mels-diner.de/ | +49 511 862310 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mensa | - | OTHER | - | -/- | https://www.gymnasium-isernhagen.de/mensa/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mensa HMTMH | 30175 | OTHER | PICKUP,PHONE | -/A | https://www.studentenwerk-hannover.de/essen/mensen-und-cafes/Mensa%20HMTMH | 0511-3100217 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Meteora | 30161 | GREEK | PHONE,PICKUP | -/A | https://www.meteora-hannover.de | +49 511 315237 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mezem | 30159 | OTHER | PHONE,PICKUP | -/A | https://mezemrestaurant.de/ | +49 511 51512170 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Milazzo | 30625 | ITALIAN,PIZZA | PHONE | -/A | https://restaurant-milazzo.de | +49 511 556601 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Mimi Fusion | - | ASIAN,VIETNAMESE,SUSHI | PHONE,PICKUP | -/A | http://mimifusion.de | +49 511 84489696 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mio Mio | - | ITALIAN | PHONE,PICKUP | -/A | https://www.miomiolinden.de/ | +49 511 54358283 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Misik | 30161 | OTHER | - | -/- | https://www.misik-hannover.com/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mon Bonheur | 30163 | OTHER | PHONE,PICKUP | -/A | https://www.monbonheur.de | +49 511 53078717 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Monte Collo No.1 | 30625 | ITALIAN | PHONE,PICKUP | -/A | - | +49 511 5333488 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Montelliana | 30539 | ITALIAN | PHONE,PICKUP | -/A | https://www.restaurant-montelliana.de | +49 511 98226689 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Morava | 30453 | OTHER | PHONE,PICKUP | -/A | - | +49 511 409966 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mosaik | 30163 | OTHER | - | -/- | https://mosaik.cafe/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Mr. Chen Hannover | - | CHINESE | PHONE,PICKUP | -/A | - | +49 511 57000908 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | My My Asian Bistro | 30455 | ASIAN | PHONE,PICKUP | -/A | - | +49 511 4735436 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Napoli 47 | 30451 | PIZZA | PHONE,PICKUP | -/A | https://napoli47.de | +49 511 48973171 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Nasim Banoo | - | INDIAN | - | -/- | https://www.nasimbanoo-hannover.com/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Natural Pizza | 30171 | PIZZA | PHONE,PICKUP | -/A | - | +49 511 5689555 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Nefis | 30167 | TURKISH | PHONE,PICKUP | L/A | https://nefishannover.de/ | +49 051149538959 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Nemo-Sushi | 30453 | SUSHI | PHONE,PICKUP | -/A | - | +49 152 11983411 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Net Viet | - | VIETNAMESE | PHONE,PICKUP | -/A | - | +49 511 21949787 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Niki | - | GREEK | - | -/- | http://www.niki-restaurant.de/ | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Noahs Kitchen | 30625 | OTHER | PHONE,PICKUP | -/A | - | +49 511 48975064 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | NTV 09 Gaststätte | - | OTHER | - | -/- | https://www.ntv09.de/clubgaststaette.cfm | - | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | NY Italian Buffet | 30159 | ITALIAN | PHONE,PICKUP | -/A | https://www.ny-italian.com/hannover-city | +49 162 7880673 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Nét Hutf | 30169 | ASIAN,THAI,VIETNAMESE | PHONE,PICKUP | -/A | - | +49 511 8060141 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | O Sole Mio | 30159 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | - | +49 511 324794 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | O'Atlantico | 30451 | OTHER | PHONE | -/A | https://www.spanische-restaurants.com/oatlantico/ | +49 511 448239 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Oji Long | 30159 | SUSHI,ASIAN | - | -/- | https://www.ojilong.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ombra | - | ITALIAN | PHONE,PICKUP | -/A | https://ombra-hannover.de/ | +49 152 27655273 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Omêly | 30173 | ASIAN | PHONE,PICKUP | -/A | - | +49 511 53076111 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Onel's Döner | 30459 | TURKISH | PHONE,PICKUP | -/A | - | +49 511 38871211 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Oregano Grillhaus | 30419 | GREEK | PHONE,PICKUP | -/A | https://oregano-grill.com/ | +49 511 76800230 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Palios | 30659 | GREEK | PHONE,PICKUP | -/A | https://restaurant-palios.de/ | +49 511 80603291 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Papa Enzos | 30169 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | https://www.papaenzos-hannover.de/ | +49 05119886061 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Parkrestaurant | 30175 | OTHER | PHONE,PICKUP | -/A | https://hcc-parkrestaurant.de/ | +49 511 81130 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pasta & Pizza | 30167 | ITALIAN,PIZZA | PHONE | -/A | https://pastaundpizza-hannover.de | +49511 703268 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Pharos | 30177 | OTHER | PHONE,PICKUP | -/A | https://pharos-restaurant.de/ | +49 511 6965603 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pho 3 mien | 30159 | ASIAN | PHONE,PICKUP | -/A | http://www.pho3mien.de | +49 511 10531443 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pho Viet Nam | 30159 | ASIAN | PHONE,PICKUP | -/A | https://vietnampho.de/ | +49 511 8972345 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Piccoliâs Roadhouse | 30159 | AMERICAN | PHONE,PICKUP | -/A | https://piccolis-roadhouse.de/home.html | +49 511 7011888 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Piri Piri | 30451 | PIZZA,GRILL | PHONE,PICKUP | L/A | https://piripirihannover.de/ | +49 152 11351188 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Bulls | 30625 | PIZZA | PHONE,PICKUP | -/A | https://www.pizzabulls.de/unsere-filialen/hannover-kleefeld | +49 176 20465326 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Familia | 30519 | BURGER,PIZZA | PHONE,PICKUP | -/A | https://www.pizzafamilia.de/ | +49 511 86693972 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Freund | 30179 | PIZZA,ITALIAN | PHONE,PICKUP | L/A | https://www.pizzafreundhannover.de/ | +49 511 666555 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Günes | 30451 | PIZZA | PHONE,PICKUP | -/A | https://pizza-guenes.de | +49 051189700794 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza House | 30161 | PIZZA,ITALIAN | PHONE,PICKUP | L/A | https://www.pizza-house-hannover.de/ | +49 511 89841100 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Mario | 30519 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | http://www.hannoverpizza.de | +49 511 868681 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizza Master | 30419 | PIZZA | - | -/- | https://www.pizzamaster-in-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizzeria Napoli | 30449 | ITALIAN | PHONE,PICKUP | -/A | - | +49 511 454882 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizzeria Riccardo | 30159 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | https://www.pizzeria-riccardo-hannover.de/ | +49 511 14245 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pizzeria Taormina | 30625 | ITALIAN,PIZZA | PHONE,PICKUP | -/A | - | +49 511 5332721 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Pommesglück | 30159 | OTHER | - | -/- | https://pommesglueck.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Praga Grill | 30419 | GREEK | - | -/- | https://www.pargagrill-hannover.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Presto Zelos | 30459 | PIZZA,DOENER,GREEK | PHONE,PICKUP | L/A | https://prestozelos.de/ | +49 511 89814051 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | PWND BY YIKEZ | 30539 | OTHER | PHONE,PICKUP | -/A | - | +49 511 23562220 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Raj | 30519 | INDIAN | PHONE,PICKUP | -/A | https://raj-hannover.de/ | +49 511 8991213 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Rembetiko | 30539 | GREEK | PHONE,PICKUP | -/A | https://www.rembetiko-hannover.de/de | +49 511 12374152 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant & Bar NUOVO | 30659 | BURGER | PHONE | -/A | https://www.nuovo-restaurant.de/ | +49 511 71300792 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant Achilles | 30163 | GREEK | PHONE,PICKUP | -/A | https://www.www.achilles-hannover.de/ | +49 511 622227 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Cafe bellâ ARTE | 30169 | ITALIAN | - | -/- | https://www.bellarte.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Donau | 30519 | OTHER | PHONE,PICKUP | -/A | https://restaurant-donau.de/ | +49 511 864003 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Hiller | 30159 | OTHER | PHONE,PICKUP | -/A | https://www.restaurant-hiller.de/ | +49 511 321288 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant im Polizei-Sportverein | 30625 | OTHER | PHONE | -/A | https://psv-hannover.de/ | +49 511 875 6530 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant im Sportpark | - | BURGER,GRILL,ITALIAN,PIZZA | PHONE | -/A | https://restaurant-am-sportpark.eatbu.com/?lang=de | +4951121906122 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant Leonardo | 30559 | OTHER | PHONE,PICKUP | -/A | - | +49 511 51030 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Oikos | 30559 | GREEK | PHONE,PICKUP | -/A | https://oikos-hannover.de/ | +49 511 78091201 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Otts | 30159 | OTHER | PHONE | -/A | https://www.restaurant-otts.de/ | +49 511 344921 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Restaurant Piano | 30655 | ITALIAN | PHONE,PICKUP | -/A | https://www.restaurant-piano.de/index.php | +49 511 45913666 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurant Schwanenburg | 30453 | OTHER | PHONE,PICKUP | -/A | https://schwanenburg.net/ | +49 511 2131701 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Restaurante Perschia | 30519 | OTHER | PICKUP,PHONE | L/A | https://www.restaurant-perschia.de/ | +49 511 87568087 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Rhodos | - | GREEK | PHONE,PICKUP | -/A | - | +49 51314595908 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ricklinger Döner | 30459 | DOENER | PHONE,PICKUP | -/A | - | +49 051160579970 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ristorante Botticelli | 30659 | ITALIAN | PHONE | -/A | https://www.botticelli-hannover.de | +49 511 27018360 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ristorante Lucca | 30559 | ITALIAN | PHONE | -/A | https://www.lucca-ecco.de/ | +49 511 65512256 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Ristorantino Stromboli | 30177 | ITALIAN | PHONE,PICKUP | -/A | https://www.ristorantino-stromboli.de/ | +49 511 87949392 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Riva | 30173 | OTHER | PHONE,PICKUP | -/A | https://riva-hannover.com/ | +49 511 97827687 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Romantico | 30629 | ITALIAN | PHONE,PICKUP | -/A | https://romantico-hannover.de | +49 511 54458221 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Rotonda Bistro Origlio | 30159 | ITALIAN | PHONE,PICKUP | -/A | https://ristorante-rotonda.de/rotonda-bistro-origlio/ | +49 511 324104 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Roy's Restaurant | 30175 | ITALIAN | PICKUP,PHONE | -/A | https://www.roys-hannover.de/ | +49 511 89767671 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Royal Donuts | 30451 | OTHER | PHONE,PICKUP | -/A | https://www.royal-donuts.de/ | +49 511 44455678 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Ruenthai | 30159 | ASIAN | PHONE | -/A | https://www.ruenthai.de/ | +49 511 328999 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Safran | 30159 | OTHER | PHONE | -/A | https://safran-hannover.eatbu.com/?lang=de | +4951164712019 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sagir | 30171 | INDIAN | PHONE,PICKUP | -/A | http://www.sagir-restaurant.de/ | +49 511 2353593 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Salatfreunde | 30161 | OTHER | PHONE,PICKUP | -/A | https://www.salatfreunde.de/ | +49 171 1112114 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Salatküche | 30449 | OTHER | PHONE,PICKUP | -/A | - | +49 511 84400977 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Salentino | 30161 | ITALIAN | PHONE | -/A | https://italiener-hannover.de | +49 511 3882782 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | SANDY | - | BURGER,DOENER,PIZZA,TURKISH | PHONE,PICKUP | -/A | - | +49 511 43838881 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Schlossküche Herrenhausen | 30419 | OTHER | PHONE,PICKUP | -/A | http://www.schlosskueche-herrenhausen.de | +49 511 2794940 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Schnitzelbudenhaus | - | OTHER | PHONE,PICKUP | -/A | - | +49 511 77060 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Schützenhaus Anderten | 30559 | OTHER | PHONE | -/A | https://schuetzenhaus-anderten.de | +49 511 528644 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Shabba Dee's Kitchen | - | OTHER | PHONE,PICKUP | -/A | https://www.shabbadeeskitchen.com/ | +49 173 7175042 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Shahr Raz | 30165 | OTHER | PHONE,PICKUP | -/A | https://www.shahr-raz-persisches-restaurant-hannover.de/ | +49 511 67660313 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Shin Ramen | 30159 | ASIAN | PHONE | -/A | https://www.shin-foods.com/de/ | +495115474240 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | shiva curry | - | THAI | PHONE,PICKUP | -/A | - | +49 511 77957828 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sindo Sushi | 30163 | ASIAN,SUSHI | PHONE,PICKUP | -/A | https://www.sindo-restaurant.de/ | +49 511 661188 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Singapur | 30419 | CHINESE | PHONE,PICKUP | -/A | - | +49 05112712210 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Siro's Pizza | 30165 | PIZZA,ITALIAN | PHONE,PICKUP | L/A | https://sirospizza.de/ | +49 511 39084080 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sole Mio | - | ITALIAN | PHONE,PICKUP | -/A | https://solemio-hannover.de | +49 511 61659270 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Soulkitchen | 30449 | OTHER | PHONE | -/A | http://soulkitchen-linden.de/ | +49 511 45008510 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Speiserei | 30175 | OTHER | PHONE | -/A | https://speiserei-hannover.de/ | +49 511 858921 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Spoon | 30161 | ITALIAN,PIZZA | PHONE | -/A | https://www.spoon-hannover.de | +49 162 3068657 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Spätzle Haus | 30419 | OTHER | PHONE | -/A | https://www.spaetzlehaus.de | +49 511 795433 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://www.stadtmauer-hannover.de/ | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://stadtmauer-hannover.de/index3.php | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://stadtmauer-hannover.de/ | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Stadtmauer | 30161 | OTHER | PHONE,PICKUP | -/A | https://www.stadtmauer-hannover.de/index2.php | +49 511 99987454 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Stromboli | 30163 | ITALIAN | PHONE | -/A | https://ristorantino-stromboli.de/ | +49 511 87949392 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Sumer Restaurant | 30519 | OTHER | PHONE,PICKUP | -/A | - | +49 176 45957745 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Suppenhandlung | 30167 | OTHER | PHONE,PICKUP | -/A | https://www.suppenhandlung.de/ | +49 051134083630 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sushi Gim | 30169 | ASIAN,SUSHI | PHONE,PICKUP | -/A | https://sushi-bar-gim.de/ | +49 511 7000259 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Sushi-Do | 30159 | ASIAN,SUSHI | PHONE | -/A | https://www.sushi-do.de/ | +49 511 2203572 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Swaad | 30167 | INDIAN | PHONE,PICKUP | -/A | - | +49 511 60499188 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Symposion | - | GREEK | PHONE,PICKUP | -/A | https://www.symposion-restaurant.de/ | +49 511 816100 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tadim Kebap | - | TURKISH | PHONE,PICKUP | -/A | - | +49 163 9543000 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Taj Mahal | 30175 | INDIAN | PHONE | -/A | https://www.tajmahal.de/ | +49 511 3481714 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Takumi | 30159 | OTHER | - | -/- | https://www.takumiramennoodles.com | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tanara | 30625 | OTHER | PHONE,PICKUP | -/A | https://tanara-restaurant.de | +49 511 559371 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tandure | 30167 | TURKISH | PHONE,PICKUP | -/A | https://www.tandure.de/ | +49 172 3007951 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tante Franz | 30167 | OTHER | PHONE,PICKUP | -/A | https://tantefranz.com | +49 511 21576207 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Taverne Platia | 30159 | GREEK | PHONE,PICKUP | -/A | - | +49 511 7635444 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tesoro | 30171 | ITALIAN | PHONE,PICKUP | -/A | https://www.ristorante-tesoro.de/ | +49 511 89931134 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Thai Food in the Box | 30159 | THAI | PHONE,PICKUP | -/A | https://www.thaifood-inthebox.de/ | +49 511 1692245 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | The Harp | - | BURGER | - | -/- | https://www.theharplinden.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | The Porters | 30167 | BURGER | PHONE,PICKUP | -/A | - | +49 511 52489791 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | The Urfa Kebab | 30455 | DOENER,TURKISH | - | -/- | https://theurfakebab.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | The Wild Duck | 30177 | ASIAN | PHONE,PICKUP | -/A | https://thewildduck.de | +49 511 84868464 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tiflisi | 30519 | OTHER | PHONE,PICKUP | -/A | - | +49 511 35333713 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tina II | 30655 | GREEK | PHONE | -/A | https://www.restaurant-tina2.de | +49 511 6479400 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Tomo Sushi | 30175 | SUSHI,ASIAN | PHONE,PICKUP | L/A | https://tomosushi.de/ | +49 511 343443 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Trattoria Ciao Ciao | 30175 | ITALIAN | PHONE,PICKUP | -/A | - | +49 177 5444948 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Trattoria da Giorgio | 30449 | ITALIAN | PHONE,PICKUP | -/A | https://www.trattoria-dagiorgio-hannover.de/ | +49 511 455453 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Treibhaus | 30163 | ITALIAN,MEXICAN,OTHER | PHONE,PICKUP | -/A | http://www.treibhaus-hannover.de | +49 511 664411 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | TRIO Ristorantino Eiscafe und Bar | 30625 | ITALIAN | PHONE | -/A | https://trio-restaurant.de/ | +49 511 3533195 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Trocadero | 30419 | ITALIAN | PHONE,PICKUP | -/A | https://www.restaurant-trocadero.de/ | +49 511 4754135 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Tru Story | - | ASIAN | PHONE | -/A | https://tru-story.de | +49 511 21552960 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Urfa Tadim | - | DOENER,PIZZA | PHONE,PICKUP | -/A | - | +49 511 70815012 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Valdet Steak & Burger by Dichterklause | 30177 | BURGER | PHONE,PICKUP | -/A | - | +49 511 89880006 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Veggiche Çiğ Köfte | 30451 | TURKISH | PHONE,PICKUP | -/A | - | +49 176 31431315 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Veraci | - | ITALIAN | PHONE,PICKUP | -/A | https://veraci-hannover.de/ | +49 511 64714598 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Vereinsgaststätte Bornumer Holz | - | OTHER | - | -/- | https://www.bornumer-holz.de/ | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Vina 97 Restaurant | - | ASIAN | PHONE,PICKUP | -/A | https://www.vina97restaurant.com/ | +49 511 2102888 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | vino kebab | 30459 | DOENER,PIZZA,TURKISH | PHONE,PICKUP | L/A | https://restaurant-zaza.de/ | +49 511 64710665 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | vorveg | 30169 | OTHER | PHONE | -/A | https://www.vorveghannover.de | +49 151 57725191 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Waldgasthaus Entenfang | 30419 | OTHER | - | -/- | http://www.entenfang-hannover.de | - | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Werkhof Restaurant | 30167 | OTHER | PHONE | -/A | https://werkhof-hannover.de/restaurant | +49 511 35356380 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Wirtshaus Hannover | 30159 | OTHER | PICKUP,PHONE | -/A | https://wirtshaus-hannover.de/ | +49 511 99999691 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Wong-Kei | - | CHINESE | PHONE,PICKUP | -/A | - | +49 511 486290 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Xenos | 30419 | GREEK | PHONE,PICKUP | -/A | - | +49 511 37381136 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Zaka | 30659 | ITALIAN | PHONE,PICKUP | -/A | - | +49 511 22842450 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Zio Totonno | 30171 | ITALIAN | PHONE,PICKUP | -/A | https://www.zio-totonno.de/ | +49 511 8074418 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Zorbas | 30419 | GREEK | PICKUP,PHONE | -/A | https://www.zorbas-in-hannover.de/ | +49 511 637292 | Impressum:ja Kanal:ja PLZ:ja | - |
| [ ] | Zurück zum Glück | 30175 | OTHER | PHONE,PICKUP | -/A | https://www.zurueckzumglueck.de | +49 511 89978880 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | ÎÎÎÎÎÎ£ | 30169 | GREEK,INDIAN | PHONE,PICKUP | -/A | https://www.anemos-hannover.de | +49 511 95483483 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Öz Tatlises | - | DOENER,TURKISH | PHONE,PICKUP | -/A | - | +49 511 1694691 | Impressum:nein Kanal:nein PLZ:nein | - |
| [ ] | Öz Urfa | 30169 | TURKISH | PHONE | -/A | https://www.oezurfa.de/ | 05111319079 | Impressum:ja Kanal:ja PLZ:ja | - |
