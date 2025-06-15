package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class Recipe(
    @SerializedName("idMeal") var id : Int? = null,
    @SerializedName("strMeal") var recipeName : String? = null,
    @SerializedName("strMealThumb") var recipeImage : String? = null
)
