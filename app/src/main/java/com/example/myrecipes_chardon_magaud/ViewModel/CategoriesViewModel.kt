package com.example.myrecipes_chardon_magaud.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myrecipes_chardon_magaud.Model.Categories
import com.example.myrecipes_chardon_magaud.Repository.CategoriesRepositories
import kotlinx.coroutines.launch

class CategoriesViewModel : ViewModel() {

    private val repository = CategoriesRepositories()

    private val _categories = MutableLiveData<List<Categories>>()
    val categories: LiveData<List<Categories>> get() = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val result = repository.getCategories()
                _categories.value = result
            } catch (e: Exception) {
                Log.e("CategoriesViewModel", "Error fetching categories", e)
            }
        }
    }
}