package com.example.cocktailbar.domain

import androidx.lifecycle.LiveData

interface CoctailsRepository {
    fun addCoctailItem(item: Coctail)
    fun editCoctailItem(item: Coctail)
    fun getCoctailItem(coctailId: Int): Coctail
    fun deleteCoctailItem(coctailId: Int)
    fun getCoctailsList(): LiveData<List<Coctail>>

}