package de.p2pfood.app.data.local

import de.p2pfood.app.data.AppJson
import de.p2pfood.app.data.model.Address
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.model.VerificationStatus
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

fun Restaurant.toEntity(): RestaurantEntity = RestaurantEntity(
    id = id,
    regionId = regionId,
    name = name,
    street = address.street,
    postcode = address.postcode,
    city = address.city,
    lat = lat,
    lon = lon,
    phone = phone,
    website = website,
    orderUrl = orderUrl,
    orderTypes = AppJson.instance.encodeToString(orderTypes),
    cuisines = AppJson.instance.encodeToString(cuisines),
    openingHours = openingHours,
    delivers = delivers,
    pickup = pickup,
    deliveryAreas = AppJson.instance.encodeToString(deliveryAreas),
    minOrderValue = minOrderValue,
    deliveryFee = deliveryFee,
    status = status.name,
    lastVerified = lastVerified,
    source = source,
    notes = notes,
)

fun RestaurantEntity.toModel(): Restaurant = Restaurant(
    id = id,
    regionId = regionId,
    name = name,
    address = Address(street = street, postcode = postcode, city = city),
    lat = lat,
    lon = lon,
    phone = phone,
    website = website,
    orderUrl = orderUrl,
    orderTypes = AppJson.instance.decodeFromString(orderTypes),
    cuisines = AppJson.instance.decodeFromString(cuisines),
    openingHours = openingHours,
    delivers = delivers,
    pickup = pickup,
    deliveryAreas = AppJson.instance.decodeFromString(deliveryAreas),
    minOrderValue = minOrderValue,
    deliveryFee = deliveryFee,
    status = VerificationStatus.valueOf(status),
    lastVerified = lastVerified,
    source = source,
    notes = notes,
)
