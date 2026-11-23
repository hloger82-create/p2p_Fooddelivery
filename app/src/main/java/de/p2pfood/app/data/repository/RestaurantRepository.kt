package de.p2pfood.app.data.repository

import android.content.Context
import de.p2pfood.app.data.local.RestaurantDao
import de.p2pfood.app.data.local.toEntity
import de.p2pfood.app.data.local.toModel
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.region.RegionCatalog
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RestaurantRepository(
    private val dao: RestaurantDao,
    private val catalog: RegionCatalog,
    private val context: Context,
) {

    suspend fun ensureRegionSeeded(regionId: String) {
        if (dao.count(regionId) == 0) {
            val entities = catalog.loadRestaurantSeed(regionId).map { it.toEntity() }
            dao.upsertAll(entities)
        }
    }

    fun observeRestaurants(regionId: String): Flow<List<Restaurant>> =
        dao.observeByRegion(regionId).map { list -> list.map { it.toModel() } }

    suspend fun getRestaurant(id: String): Restaurant? = dao.getById(id)?.toModel()
}
