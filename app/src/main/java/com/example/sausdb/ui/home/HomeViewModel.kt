package com.example.sausdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sausdb.data.recipe.RecipeRepository
import com.example.sausdb.model.Recipe
import kotlinx.coroutines.launch

data class HomeUiState(
    val recipe: Recipe = Recipe(0, "", "", "", "")
)

class HomeViewModel(
    private val repository: RecipeRepository
) : ViewModel() {

    fun saveRecipe(recipe: Recipe) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }
}
