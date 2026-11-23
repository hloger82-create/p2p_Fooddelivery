package de.p2pfood.app.ui.components

import androidx.compose.ui.graphics.Color
import de.p2pfood.app.data.model.Cuisine

fun Cuisine.color(): Color = when (this) {
    Cuisine.PIZZA -> Color(0xFFE53935)
    Cuisine.ITALIAN -> Color(0xFF43A047)
    Cuisine.DOENER -> Color(0xFF8E24AA)
    Cuisine.TURKISH -> Color(0xFF00897B)
    Cuisine.ASIAN -> Color(0xFFFB8C00)
    Cuisine.SUSHI -> Color(0xFFEC407A)
    Cuisine.BURGER -> Color(0xFF6D4C41)
    Cuisine.AMERICAN -> Color(0xFF3949AB)
    Cuisine.GRILL -> Color(0xFFD84315)
    Cuisine.CHINESE -> Color(0xFFC2185B)
    Cuisine.VIETNAMESE -> Color(0xFF9CCC65)
    Cuisine.THAI -> Color(0xFFFDD835)
    Cuisine.INDIAN -> Color(0xFFFF7043)
    Cuisine.MEXICAN -> Color(0xFF00ACC1)
    Cuisine.GREEK -> Color(0xFF1E88E5)
    Cuisine.OTHER -> Color(0xFF757575)
}
