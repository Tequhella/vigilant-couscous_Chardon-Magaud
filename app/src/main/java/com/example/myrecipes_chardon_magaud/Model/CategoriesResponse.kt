package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories") val categories: List<Categories>
)
