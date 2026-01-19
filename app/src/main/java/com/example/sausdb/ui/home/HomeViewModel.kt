package com.example.sausdb.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.sausdb.data.database.AppDatabase
import com.example.sausdb.data.recipe.RecipeRepository
import com.example.sausdb.model.Recipe
import kotlinx.coroutines.launch

data class HomeUiState(
    val recipe: Recipe = Recipe(0, "", "", "", "")
)

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: RecipeRepository

    init {
        val database = AppDatabase.getDatabase(application)
        repository = RecipeRepository.RecipeRepositoryImpl(database.recipeDao(), application)
    }

    fun saveRecipe(recipe: Recipe) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }
}
