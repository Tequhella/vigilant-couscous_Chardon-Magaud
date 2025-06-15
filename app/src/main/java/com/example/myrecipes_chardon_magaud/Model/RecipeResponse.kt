package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class RecipeResponse(
    @SerializedName("meals") val recipes: List<Recipe>
)
