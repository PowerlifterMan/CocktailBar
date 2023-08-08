package com.example.cocktailbar.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coctails")
data class CoctailDBModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var description: String? = null,
    var ingredients: String,
    var recipe: String? = null,
    var pictureId: Int
)
