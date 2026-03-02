package com.example.sausdb.ui.saus

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sausdb.data.recipe.RecipeRepository

class SausViewModelFactory(
    private val repository: RecipeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SausViewModel(repository as RecipeRepository.RecipeRepositoryImpl) as T
    }
}
