package com.example.myrecipes_chardon_magaud.Repository

import com.example.myrecipes_chardon_magaud.API.ApiClient
import com.example.myrecipes_chardon_magaud.API.ITheMealdbApi
import com.example.myrecipes_chardon_magaud.Model.Categories

class CategoriesRepositories {
    private val apiService: ITheMealdbApi = ApiClient.instance.create(ITheMealdbApi::class.java)

    suspend fun getCategories(): List<Categories> {
        return apiService.getCategories().categories
    }
}