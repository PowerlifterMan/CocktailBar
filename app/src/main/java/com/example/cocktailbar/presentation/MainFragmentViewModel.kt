package com.example.cocktailbar.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cocktailbar.data.CoctailRepositoryImpl
import com.example.cocktailbar.domain.Interactor

class MainFragmentViewModel (application: Application): AndroidViewModel(application) {

    private val repository = CoctailRepositoryImpl(application)
    private val interactor = Interactor(repository)
    val coctailList = interactor.getCoctailList()

    fun getList() = interactor.getCoctailList()

}