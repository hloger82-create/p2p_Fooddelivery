package de.p2pfood.app.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class OrderType {
    WEBSHOP,
    PHONE,
    PICKUP,
}

@Serializable
enum class Cuisine {
    PIZZA,
    ITALIAN,
    DOENER,
    TURKISH,
    ASIAN,
    SUSHI,
    BURGER,
    AMERICAN,
    GRILL,
    CHINESE,
    VIETNAMESE,
    THAI,
    INDIAN,
    MEXICAN,
    GREEK,
    OTHER,
}

@Serializable
enum class VerificationStatus {
    @SerialName("verified") VERIFIED,
    @SerialName("pending_review") PENDING_REVIEW,
    @SerialName("rejected") REJECTED,
}

@Serializable
data class Address(
    val street: String? = null,
    val postcode: String? = null,
    val city: String? = null,
)

@Serializable
data class Restaurant(
    val id: String,
    val regionId: String,
    val name: String,
    val address: Address,
    val lat: Double? = null,
    val lon: Double? = null,
    val phone: String? = null,
    val website: String? = null,
    val orderUrl: String? = null,
    val orderTypes: List<OrderType> = emptyList(),
    val cuisines: List<Cuisine> = emptyList(),
    val cuisineSource: String? = null,
    val openingHours: String? = null,
    val delivers: Boolean = false,
    val pickup: Boolean = true,
    val deliveryAreas: List<String> = emptyList(),
    val minOrderValue: Double? = null,
    val deliveryFee: Double? = null,
    val status: VerificationStatus = VerificationStatus.PENDING_REVIEW,
    val lastVerified: String? = null,
    val featured: Boolean = false,
    val source: String = "manual",
    val notes: String? = null,
)

@Serializable
data class RegionConfig(
    val id: String,
    val name: String,
    val country: String = "DE",
    val centerLat: Double,
    val centerLon: Double,
    val zoom: Double = 12.0,
    val bbox: List<Double>? = null,
    val osmAreaName: String? = null,
    val postcodes: List<String> = emptyList(),
    val platformBlocklist: List<String> = emptyList(),
    val datasetUrl: String? = null,
    val reportUrl: String? = null,
    val donateUrl: String? = null,
)
