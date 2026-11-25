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
        withContext(Dispatchers.IO) {
            // Immer aus den gebündelten Assets aktualisieren und veraltete Eintraege entfernen,
            // damit ein App-Update auch ohne Netzwerk den Datensatz bereinigt.
            val entities = catalog.loadRestaurantSeed(regionId).map { it.toEntity() }
            dao.upsertAll(entities)
            replaceMissing(regionId, entities.map { it.id })
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
            // Replace-Semantik: remote ist massgeblich - entfernte Eintraege (z. B. QS-Ausschluesse) muessen lokal verschwinden
            dao.upsertAll(dataset.restaurants.map { it.toEntity() })
            replaceMissing(regionId, dataset.restaurants.map { it.id })
            favoriteDao.deleteOrphans()
        } catch (e: Exception) {
            // offline oder URL nicht erreichbar -> lokale Assets bleiben aktiv
        }
    }

    private suspend fun replaceMissing(regionId: String, keepIds: List<String>) {
        if (keepIds.isEmpty()) dao.deleteByRegion(regionId) else dao.deleteNotIn(regionId, keepIds)
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
