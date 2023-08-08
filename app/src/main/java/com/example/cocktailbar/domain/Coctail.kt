package com.example.cocktailbar.domain

import com.example.cocktailbar.R

data class Coctail(
    val id: Int,
    var name: String,
    var description: String? = null,
    var ingredients: String,
    var recipe: String? = null,
    var pictureId: Int = R.drawable.ic_summer
)
