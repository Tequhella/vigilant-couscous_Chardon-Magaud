package com.example.myrecipes_chardon_magaud.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes_chardon_magaud.API.ApiClient
import com.example.myrecipes_chardon_magaud.API.ITheMealdbApi
import com.example.myrecipes_chardon_magaud.Model.Recipe
import com.example.myrecipes_chardon_magaud.Repository.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val repository: RecipeRepository

    init {
        val api = ApiClient.instance.create(ITheMealdbApi::class.java)
        repository = RecipeRepository(api)
    }

    private val _recipes = MutableLiveData<List<Recipe>>()
    val recipes: LiveData<List<Recipe>> = _recipes

    fun getRecipes(categoryName: String) {
        viewModelScope.launch {
            try {
                val result = repository.getRecipesByCategory(categoryName)
                _recipes.value = result ?: emptyList()
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Error: ${e.message}")
            }
        }
    }
}