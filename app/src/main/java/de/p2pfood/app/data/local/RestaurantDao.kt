package de.p2pfood.app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RestaurantDao {

    @Query("SELECT * FROM restaurants WHERE regionId = :regionId ORDER BY name ASC")
    fun observeByRegion(regionId: String): Flow<List<RestaurantEntity>>

    @Query("SELECT COUNT(*) FROM restaurants WHERE regionId = :regionId")
    suspend fun count(regionId: String): Int

    @Query("SELECT COUNT(*) FROM restaurants WHERE regionId = :regionId")
    fun observeCount(regionId: String): Flow<Int>

    @Query("SELECT * FROM restaurants WHERE id = :id")
    suspend fun getById(id: String): RestaurantEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<RestaurantEntity>)

    @Query("DELETE FROM restaurants WHERE regionId = :regionId AND id NOT IN (:keepIds)")
    suspend fun deleteNotIn(regionId: String, keepIds: List<String>)

    @Query("DELETE FROM restaurants WHERE regionId = :regionId")
    suspend fun deleteByRegion(regionId: String)
}
