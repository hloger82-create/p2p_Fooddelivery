package de.p2pfood.app.ui.components

import de.p2pfood.app.data.model.Cuisine
import de.p2pfood.app.data.model.OrderType

fun Cuisine.label(): String = when (this) {
    Cuisine.PIZZA -> "Pizza"
    Cuisine.ITALIAN -> "Italienisch"
    Cuisine.DOENER -> "Döner"
    Cuisine.TURKISH -> "Türkisch"
    Cuisine.ASIAN -> "Asiatisch"
    Cuisine.SUSHI -> "Sushi"
    Cuisine.BURGER -> "Burger"
    Cuisine.AMERICAN -> "American"
    Cuisine.GRILL -> "Grill"
    Cuisine.CHINESE -> "Chinesisch"
    Cuisine.VIETNAMESE -> "Vietnamesisch"
    Cuisine.THAI -> "Thailändisch"
    Cuisine.INDIAN -> "Indisch"
    Cuisine.MEXICAN -> "Mexikanisch"
    Cuisine.GREEK -> "Griechisch"
    Cuisine.OTHER -> "Sonstiges"
}

fun OrderType.label(): String = when (this) {
    OrderType.WEBSHOP -> "Online-Shop"
    OrderType.PHONE -> "Telefon"
    OrderType.PICKUP -> "Abholung"
}
