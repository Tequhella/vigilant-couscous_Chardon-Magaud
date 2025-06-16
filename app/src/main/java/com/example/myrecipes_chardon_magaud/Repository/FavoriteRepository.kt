package com.example.myrecipes_chardon_magaud.Repository

import com.example.myrecipes_chardon_magaud.DAO.FavoriteRecipeDao
import com.example.myrecipes_chardon_magaud.Entity.FavoriteRecipeEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(private val dao: FavoriteRecipeDao) {

    fun getAllFavorites(): Flow<List<FavoriteRecipeEntity>> = dao.getAll()

    suspend fun addFavorite(recipe: FavoriteRecipeEntity) = dao.insert(recipe)

    suspend fun removeFavorite(recipe: FavoriteRecipeEntity) = dao.delete(recipe)

    suspend fun getById(id: Int): FavoriteRecipeEntity? = dao.getById(id)
}