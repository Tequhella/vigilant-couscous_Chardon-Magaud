package com.example.myrecipes_chardon_magaud.Model

import com.google.gson.annotations.SerializedName

data class RecipeDetail(
    @SerializedName("idMeal") var id : Int? = null,
    @SerializedName("strMeal") var recipeName : String? = null,
    @SerializedName("strCategory") var categorieName : String? = null,
    @SerializedName("strArea") var area : String? = null,
    @SerializedName("strMealThumb") var recipeImage : String? = null,
    @SerializedName("strInstructions") var instructions : String? = null,

    @SerializedName("strIngredient1")  val ing1: String? = null,
    @SerializedName("strIngredient2")  val ing2: String? = null,
    @SerializedName("strIngredient3")  val ing3: String? = null,
    @SerializedName("strIngredient4")  val ing4: String? = null,
    @SerializedName("strIngredient5")  val ing5: String? = null,
    @SerializedName("strIngredient6")  val ing6: String? = null,
    @SerializedName("strIngredient7")  val ing7: String? = null,
    @SerializedName("strIngredient8")  val ing8: String? = null,
    @SerializedName("strIngredient9")  val ing9: String? = null,
    @SerializedName("strIngredient10") val ing10: String? = null,
    @SerializedName("strIngredient11") val ing11: String? = null,
    @SerializedName("strIngredient12") val ing12: String? = null,
    @SerializedName("strIngredient13") val ing13: String? = null,
    @SerializedName("strIngredient14") val ing14: String? = null,
    @SerializedName("strIngredient15") val ing15: String? = null,
    @SerializedName("strIngredient16") val ing16: String? = null,
    @SerializedName("strIngredient17") val ing17: String? = null,
    @SerializedName("strIngredient18") val ing18: String? = null,
    @SerializedName("strIngredient19") val ing19: String? = null,
    @SerializedName("strIngredient20") val ing20: String? = null,

    @SerializedName("strMeasure1")  val meas1: String? = null,
    @SerializedName("strMeasure2")  val meas2: String? = null,
    @SerializedName("strMeasure3")  val meas3: String? = null,
    @SerializedName("strMeasure4")  val meas4: String? = null,
    @SerializedName("strMeasure5")  val meas5: String? = null,
    @SerializedName("strMeasure6")  val meas6: String? = null,
    @SerializedName("strMeasure7")  val meas7: String? = null,
    @SerializedName("strMeasure8")  val meas8: String? = null,
    @SerializedName("strMeasure9")  val meas9: String? = null,
    @SerializedName("strMeasure10") val meas10: String? = null,
    @SerializedName("strMeasure11") val meas11: String? = null,
    @SerializedName("strMeasure12") val meas12: String? = null,
    @SerializedName("strMeasure13") val meas13: String? = null,
    @SerializedName("strMeasure14") val meas14: String? = null,
    @SerializedName("strMeasure15") val meas15: String? = null,
    @SerializedName("strMeasure16") val meas16: String? = null,
    @SerializedName("strMeasure17") val meas17: String? = null,
    @SerializedName("strMeasure18") val meas18: String? = null,
    @SerializedName("strMeasure19") val meas19: String? = null,
    @SerializedName("strMeasure20") val meas20: String? = null,
)
{
    fun getIngredientList(): List<Pair<String, String>> {
        val list = listOf(
            ing1 to meas1, ing2 to meas2, ing3 to meas3, ing4 to meas4, ing5 to meas5,
            ing6 to meas6, ing7 to meas7, ing8 to meas8, ing9 to meas9, ing10 to meas10,
            ing11 to meas11, ing12 to meas12, ing13 to meas13, ing14 to meas14, ing15 to meas15,
            ing16 to meas16, ing17 to meas17, ing18 to meas18, ing19 to meas19, ing20 to meas20
        )
        return list.filter { !it.first.isNullOrBlank() && !it.second.isNullOrBlank() }
            .map { (ingredient, measure) -> ingredient!! to measure!! }
    }

    fun initNutriScore() : Int {
        return 100 - getIngredientList().size * 5
    }
}
