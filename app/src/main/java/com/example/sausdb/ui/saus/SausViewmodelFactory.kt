package com.example.sausdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sausdb.data.recipe.RecipeRepository
import com.example.sausdb.ui.saus.SausViewModel

class SausViewModelFactory(
    private val repository: RecipeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SausViewModel(repository as RecipeRepository.RecipeRepositoryImpl) as T
    }
}
