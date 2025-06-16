package com.example.myrecipes_chardon_magaud.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_recipes")
data class FavoriteRecipeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val timestamp: Long
)