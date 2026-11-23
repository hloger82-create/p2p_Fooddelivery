package de.p2pfood.app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class RestaurantEntity(
    @PrimaryKey val id: String,
    val regionId: String,
    val name: String,
    val street: String?,
    val postcode: String?,
    val city: String?,
    val lat: Double?,
    val lon: Double?,
    val phone: String?,
    val website: String?,
    val orderUrl: String?,
    val orderTypes: String,
    val cuisines: String,
    val openingHours: String?,
    val delivers: Boolean,
    val pickup: Boolean,
    val deliveryAreas: String,
    val minOrderValue: Double?,
    val deliveryFee: Double?,
    val status: String,
    val lastVerified: String?,
    val source: String,
    val notes: String?,
)
