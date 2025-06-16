package com.example.myrecipes_chardon_magaud

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myrecipes_chardon_magaud.DAO.FavoriteRecipeDao
import com.example.myrecipes_chardon_magaud.Entity.FavoriteRecipeEntity

@Database(entities = [FavoriteRecipeEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteRecipeDao(): FavoriteRecipeDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "recipes_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}