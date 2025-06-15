package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class Categories(

    @SerializedName("idCategory") var id : Int? = null,
    @SerializedName("strCategory") var categoryName : String? = null,
    @SerializedName("strCategoryThumb") var categoryImage : String? = null
)
