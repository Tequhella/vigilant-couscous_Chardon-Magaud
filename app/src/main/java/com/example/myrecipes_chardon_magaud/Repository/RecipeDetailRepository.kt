package com.example.myrecipes_chardon_magaud.Repository

import com.example.myrecipes_chardon_magaud.API.ITheMealdbApi
import com.example.myrecipes_chardon_magaud.Model.RecipeDetail

class RecipeDetailRepository(private val api: ITheMealdbApi) {
    suspend fun getRecipeDetail(id: Int): RecipeDetail? {
        val response = api.getRecipeDetailById(id)
        return response.body()?.meals?.firstOrNull()
    }
}