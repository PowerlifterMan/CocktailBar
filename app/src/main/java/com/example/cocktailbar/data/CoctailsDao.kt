package com.example.cocktailbar.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CoctailsDao {
    @Query("SELECT * FROM coctails")
    fun getCoctailsList(): LiveData<List<CoctailDBModel>>

    @Query("SELECT * FROM coctails WHERE id=:coctailId LIMIT 1")
    fun getCoctailItem(coctailId: Int): CoctailDBModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCoctailItem(coctailDBModel: CoctailDBModel)

    @Query("DELETE FROM coctails WHERE id=:coctailId")
    fun deleteCoctailItem(coctailId: Int)

}