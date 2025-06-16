package com.example.myrecipes_chardon_magaud.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myrecipes_chardon_magaud.AppDatabase
import com.example.myrecipes_chardon_magaud.Entity.FavoriteRecipeEntity
import com.example.myrecipes_chardon_magaud.Model.RecipeDetail
import com.example.myrecipes_chardon_magaud.Repository.FavoriteRepository
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FavoriteRepository

    val favorites: LiveData<List<FavoriteRecipeEntity>>

    init {
        val dao = AppDatabase.getDatabase(application).favoriteRecipeDao()
        repository = FavoriteRepository(dao)
        favorites = repository.getAllFavorites().asLiveData()
    }

    fun addToFavorites(recipe: RecipeDetail) {
        val entity = FavoriteRecipeEntity(
            id = recipe.id ?: return,
            name = recipe.recipeName ?: "Unnamed",
            imageUrl = recipe.recipeImage ?: "",
            timestamp = System.currentTimeMillis()
        )
        viewModelScope.launch {
            repository.addFavorite(entity)
        }
    }

    fun removeFromFavorites(recipe: FavoriteRecipeEntity) {
        viewModelScope.launch {
            repository.removeFavorite(recipe)
        }
    }
}