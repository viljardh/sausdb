package com.example.sausdb.data.recipe

import android.content.Context
import com.example.sausdb.data.database.RecipeDao
import com.example.sausdb.data.database.RecipeEntity
import com.example.sausdb.model.Recipe


interface RecipeRepository {
    suspend fun getAllRecipes(): List<Recipe>
    suspend fun searchRecipes(query: String): List<Recipe>
    suspend fun insertRecipe(recipe: Recipe)
    suspend fun updateRecipe(recipe: Recipe)
    suspend fun deleteRecipe(recipe: Recipe)
}

class RecipeRepositoryImpl(
    private val recipeDao: RecipeDao,
    private val context: Context
)  : RecipeRepository {

    override suspend fun getAllRecipes(): List<Recipe> {
        return recipeDao.getAll()
    }

    override suspend fun searchRecipes(query: String): List<Recipe> {
        val searchQuery = "%$query%"
        return recipeDao.searchRecipes(searchQuery)
    }

    override suspend fun insertRecipe(recipe: Recipe) {
        val entity = fromRecipe(recipe)
        recipeDao.insertRecipe(entity)
    }

    override suspend fun updateRecipe(recipe: Recipe) {
        val entity = fromRecipe(recipe)
        recipeDao.update(entity)
    }

    override suspend fun deleteRecipe(recipe: Recipe) {
        recipeDao.delete(recipe)
    }

    private fun fromRecipe(recipe: Recipe): RecipeEntity {
        return RecipeEntity(
            id = recipe.id,
            name = recipe.name,
            description = recipe.description,
            ingredients = recipe.ingredients,
            procedure = recipe.procedure
        )
    }
}