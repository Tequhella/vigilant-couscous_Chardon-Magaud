package com.example.myrecipes_chardon_magaud.Repository

import com.example.myrecipes_chardon_magaud.API.ITheMealdbApi
import com.example.myrecipes_chardon_magaud.Model.Recipe

class RecipeRepository(private val api: ITheMealdbApi) {
    suspend fun getRecipesByCategory(category: String): List<Recipe>? {
        val response = api.getRecipesByCategory(category)
        return response.body()?.recipes
    }
}