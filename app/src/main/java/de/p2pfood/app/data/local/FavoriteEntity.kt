package de.p2pfood.app.data.local

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "favorites")
data class FavoriteEntity(
    @PrimaryKey val restaurantId: String,
)

@Dao
interface FavoriteDao {

    @Query("SELECT restaurantId FROM favorites")
    fun observeAll(): Flow<List<String>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE restaurantId = :id)")
    suspend fun isFavorite(id: String): Boolean

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(favorite: FavoriteEntity)

    @Query("DELETE FROM favorites WHERE restaurantId = :id")
    suspend fun remove(id: String)

    @Query("DELETE FROM favorites WHERE restaurantId NOT IN (SELECT id FROM restaurants)")
    suspend fun deleteOrphans()
}
