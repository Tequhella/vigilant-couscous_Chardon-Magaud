package com.example.myrecipes_chardon_magaud.API

import com.example.myrecipes_chardon_magaud.Model.CategoriesResponse
import com.example.myrecipes_chardon_magaud.Model.RecipeDetailResponse
import com.example.myrecipes_chardon_magaud.Model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITheMealdbApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    @GET("filter.php")
    suspend fun getRecipesByCategory(@Query("c") categoryName: String): Response<RecipeResponse>

    @GET("lookup.php")
    suspend fun getRecipeDetailById(
        @Query("i") id: Int
    ): Response<RecipeDetailResponse>
}