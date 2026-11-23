package de.p2pfood.app.data.repository

import android.content.Context
import de.p2pfood.app.data.AppJson
import de.p2pfood.app.data.local.FavoriteDao
import de.p2pfood.app.data.local.FavoriteEntity
import de.p2pfood.app.data.local.RestaurantDao
import de.p2pfood.app.data.local.toEntity
import de.p2pfood.app.data.local.toModel
import de.p2pfood.app.data.model.Restaurant
import de.p2pfood.app.data.region.RegionCatalog
import de.p2pfood.app.data.region.RestaurantDataset
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

class RestaurantRepository(
    private val dao: RestaurantDao,
    private val favoriteDao: FavoriteDao,
    private val catalog: RegionCatalog,
    private val context: Context,
) {

    suspend fun ensureRegionSeeded(regionId: String) {
        if (dao.count(regionId) == 0) {
            val entities = catalog.loadRestaurantSeed(regionId).map { it.toEntity() }
            dao.upsertAll(entities)
        }
    }

    suspend fun syncRemoteDataset(regionId: String) {
        val url = catalog.loadRegion(regionId).datasetUrl ?: return
        try {
            val text = withContext(Dispatchers.IO) {
                val conn = URL(url).openConnection() as HttpURLConnection
                conn.connectTimeout = 10_000
                conn.readTimeout = 10_000
                conn.inputStream.bufferedReader().use { it.readText() }
            }
            val dataset = AppJson.instance.decodeFromString<RestaurantDataset>(text)
            dao.upsertAll(dataset.restaurants.map { it.toEntity() })
        } catch (e: Exception) {
            // offline oder URL nicht erreichbar -> lokale Assets bleiben aktiv
        }
    }

    fun observeRestaurants(regionId: String): Flow<List<Restaurant>> =
        dao.observeByRegion(regionId).map { list -> list.map { it.toModel() } }

    suspend fun getRestaurant(id: String): Restaurant? = dao.getById(id)?.toModel()

    fun observeFavoriteIds(): Flow<Set<String>> =
        favoriteDao.observeAll().map { it.toSet() }

    suspend fun toggleFavorite(id: String) {
        if (favoriteDao.isFavorite(id)) favoriteDao.remove(id) else favoriteDao.add(FavoriteEntity(id))
    }
}
