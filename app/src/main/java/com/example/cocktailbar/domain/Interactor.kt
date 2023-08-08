package com.example.cocktailbar.domain

import androidx.lifecycle.LiveData

class Interactor(private val repository: CoctailsRepository) {

    fun addCoctail(item: Coctail){
        repository.addCoctailItem(item)
    }

    fun deleteCoctail(itemId: Int){
        repository.deleteCoctailItem(itemId)
    }

    fun editCoctail(item: Coctail){
        repository.editCoctailItem(item)
    }

    fun getCoctailList(): LiveData<List<Coctail>>{
        return repository.getCoctailsList()
    }

    fun getCoctailItem(itemId: Int):Coctail{
        return repository.getCoctailItem(itemId)
    }
}