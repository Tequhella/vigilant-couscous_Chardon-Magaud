package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
    @SerializedName("meals") val meals: List<RecipeDetail>
)
