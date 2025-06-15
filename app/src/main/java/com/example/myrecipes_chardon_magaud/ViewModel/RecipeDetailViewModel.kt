package com.example.myrecipes_chardon_magaud.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes_chardon_magaud.API.ApiClient
import com.example.myrecipes_chardon_magaud.API.ITheMealdbApi
import com.example.myrecipes_chardon_magaud.Model.RecipeDetail
import com.example.myrecipes_chardon_magaud.Repository.RecipeDetailRepository
import kotlinx.coroutines.launch

class RecipeDetailViewModel : ViewModel() {

    private val repository = RecipeDetailRepository(ApiClient.instance.create(ITheMealdbApi::class.java))
    private val _recipeDetail = MutableLiveData<RecipeDetail?>()
    val recipeDetail: LiveData<RecipeDetail?> = _recipeDetail

    fun loadRecipeDetail(id: Int) {
        viewModelScope.launch {
            try {
                _recipeDetail.value = repository.getRecipeDetail(id)
            } catch (e: Exception) {
                Log.e("RecipeDetailViewModel", "Erreur: ${e.message}")
            }
        }
    }
}