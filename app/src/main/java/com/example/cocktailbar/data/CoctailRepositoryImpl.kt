package com.example.cocktailbar.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.cocktailbar.domain.Coctail
import com.example.cocktailbar.domain.CoctailsRepository

class CoctailRepositoryImpl(application: Application) : CoctailsRepository {
    private val dao = AppDataBase.getInstance(application).coctailsDao()
    private val mapper = CoctailMapper()
    override fun addCoctailItem(item: Coctail) {
        dao.addCoctailItem(mapper.mapEntityToDbModel(item))
    }

    override fun editCoctailItem(item: Coctail) {
        dao.addCoctailItem(mapper.mapEntityToDbModel(item))
    }

    override fun getCoctailItem(coctailId: Int): Coctail {
        val dbModel = dao.getCoctailItem(coctailId)
        return mapper.mapDbModelToEntity(dbModel)
    }

    override fun deleteCoctailItem(coctailId: Int) {
        dao.deleteCoctailItem(coctailId)
    }

    override fun getCoctailsList(): LiveData<List<Coctail>> {
        return dao.getCoctailsList().map {
            mapper.mapListDbModelToListEntity(it)
        }
    }
}