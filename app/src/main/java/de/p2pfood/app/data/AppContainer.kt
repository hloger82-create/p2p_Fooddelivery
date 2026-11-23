package de.p2pfood.app.data

import android.content.Context
import androidx.room.Room
import de.p2pfood.app.data.local.AppDatabase
import de.p2pfood.app.data.region.RegionCatalog
import de.p2pfood.app.data.repository.RestaurantRepository

class AppContainer(context: Context) {
    private val appContext = context.applicationContext

    private val database = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "p2pfood.db",
    ).fallbackToDestructiveMigration().build()

    val regionCatalog = RegionCatalog(appContext)

    val restaurantRepository = RestaurantRepository(
        dao = database.restaurantDao(),
        favoriteDao = database.favoriteDao(),
        catalog = regionCatalog,
        context = appContext,
    )
}
