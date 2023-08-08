package com.example.cocktailbar.data

import com.example.cocktailbar.domain.Coctail

class CoctailMapper {
    fun mapEntityToDbModel(coctailItem: Coctail) = CoctailDBModel(
        id = coctailItem.id,
        name = coctailItem.name,
        description = coctailItem.description,
        ingredients = coctailItem.ingredients,
        recipe = coctailItem.recipe,
        pictureId = coctailItem.pictureId
    )

    fun mapDbModelToEntity(dBModelItem: CoctailDBModel) = Coctail(
        id = dBModelItem.id,
        name = dBModelItem.name,
        description = dBModelItem.description,
        ingredients = dBModelItem.ingredients,
        recipe = dBModelItem.recipe,
        pictureId = dBModelItem.pictureId
    )

    fun mapListDbModelToListEntity(dbModelList: List<CoctailDBModel>) =
        dbModelList.map { mapDbModelToEntity(it) }
}