package com.example.sausdb.data.recipe

import com.example.sausdb.data.database.RecipeDao
import com.example.sausdb.data.database.RecipeEntity
import com.example.sausdb.model.Recipe

class RecipeDataSource(private val recipeDao: RecipeDao) {

    suspend fun insertRecipe(recipe: RecipeEntity) {
        recipeDao.insertRecipe(recipe)
    }

    suspend fun getAllRecipes(): List<Recipe> {
        return recipeDao.getAll()
    }
}
