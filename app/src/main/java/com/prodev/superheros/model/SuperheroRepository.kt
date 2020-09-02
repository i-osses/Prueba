package com.prodev.superheros.model

import androidx.lifecycle.LiveData
import com.prodev.superheros.model.db.SuperheroDAO
import com.prodev.superheros.model.network.RetrofitInstance

class SuperheroRepository(private val dao: SuperheroDAO) {

    val superheros = dao.getAllSuperheros()

    fun deleteAll(): Int {
        return dao.deleteAll()
    }

    suspend fun getAllSuperheroes() : List<SuperheroCharacter> {
        return RetrofitInstance.api.getAllSuperheros()

    }

}
