package com.example.sausdb.model

data class Recipe (
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: String, // Stored as a comma-separated string
    val procedure: String
)