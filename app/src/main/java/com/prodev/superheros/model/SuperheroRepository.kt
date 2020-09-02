package com.prodev.superheros.model

import androidx.lifecycle.LiveData
import com.prodev.superheros.model.db.SuperheroDAO

class SuperheroRepository( private val dao : SuperheroDAO) {

    val superheros = dao.getAllSuperheros()

    fun deleteAll():Int {
        return dao.deleteAll()
    }
    fun  getLiveDataHeroListFromDB(): LiveData<List<SuperheroCharacter>> {
        return superheros
    }

    suspend fun getAllSuperheros2




}