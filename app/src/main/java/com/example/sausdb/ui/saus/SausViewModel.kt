package com.example.sausdb.ui.saus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sausdb.data.recipe.RecipeRepository
import com.example.sausdb.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SausViewModel(
    private val repository: RecipeRepository.RecipeRepositoryImpl
) : ViewModel() {

    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes: StateFlow<List<Recipe>> = _recipes.asStateFlow()

    init {
        loadRecipes()
    }

    private fun loadRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            _recipes.value = repository.getAllRecipes()
        }
    }
}
