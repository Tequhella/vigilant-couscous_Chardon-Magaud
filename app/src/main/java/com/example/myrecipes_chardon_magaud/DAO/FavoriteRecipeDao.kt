package com.example.myrecipes_chardon_magaud.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myrecipes_chardon_magaud.Entity.FavoriteRecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: FavoriteRecipeEntity)

    @Delete
    suspend fun delete(recipe: FavoriteRecipeEntity)

    @Query("SELECT * FROM favorite_recipes ORDER BY timestamp DESC")
    fun getAll(): Flow<List<FavoriteRecipeEntity>>
}