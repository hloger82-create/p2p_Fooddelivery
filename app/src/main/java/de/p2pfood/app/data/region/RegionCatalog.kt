package de.p2pfood.app.data.region

import android.content.Context
import de.p2pfood.app.data.AppJson
import de.p2pfood.app.data.model.RegionConfig
import de.p2pfood.app.data.model.Restaurant
import kotlinx.serialization.Serializable

@Serializable
data class RegionIndex(val regions: List<String>)

@Serializable
data class RestaurantDataset(
    val regionId: String,
    val restaurants: List<Restaurant>,
)

class RegionCatalog(private val context: Context) {

    private fun readAsset(path: String): String =
        context.assets.open(path).bufferedReader().use { it.readText() }

    fun availableRegionIds(): List<String> =
        AppJson.instance.decodeFromString<RegionIndex>(readAsset("regions/index.json")).regions

    fun loadRegion(regionId: String): RegionConfig =
        AppJson.instance.decodeFromString(readAsset("regions/$regionId/region.json"))

    fun loadRestaurantSeed(regionId: String): List<Restaurant> =
        AppJson.instance.decodeFromString<RestaurantDataset>(readAsset("regions/$regionId/restaurants.json")).restaurants
}
