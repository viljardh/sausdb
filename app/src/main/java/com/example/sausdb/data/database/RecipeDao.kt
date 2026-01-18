package com.example.sausdb.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.sausdb.model.Recipe

@Dao
interface RecipeDao {
    @Insert
    suspend fun insertRecipe(recipe: RecipeEntity)

    @Update
    suspend fun update(place: RecipeEntity)

    @Query("SELECT * FROM recipes")
    fun getAll(): List<Recipe>

    @Query("SELECT * FROM recipes WHERE name LIKE :query OR description LIKE :query")
    fun searchRecipes(query: String): List<Recipe>

    @Delete
    fun delete(recipe: Recipe)
}