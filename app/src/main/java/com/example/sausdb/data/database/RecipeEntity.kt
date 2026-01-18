package com.example.sausdb.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "ingredients") val ingredients: String, // Stored as a comma-separated string
    @ColumnInfo(name = "procedure") val procedure: String,
    @ColumnInfo(name = "category_id") val categoryId: Int)