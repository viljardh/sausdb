package com.example.sausdb.model

data class Recipe (
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: List<String>,
    val procedure: String
)