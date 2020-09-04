package com.prodev.superheros.model

import androidx.lifecycle.LiveData
import com.prodev.superheros.model.db.SuperheroDAO
import com.prodev.superheros.model.network.RetrofitInstance

class SuperheroRepository(private val dao: SuperheroDAO) {

    val superheros = dao.getAllSuperherosFromDB()


    fun deleteAll(): Int {
        return dao.deleteAll()
    }

/*    suspend fun getAllSuperheroes(): List<SuperheroCharacter> {
       // dao.insertAllSuperheroes(RetrofitInstance.api.getAllSuperheros())
        return RetrofitInstance.api.getAllSuperheros()
    }*/

    suspend fun getAllSuperheroes(): List<SuperheroCharacter> {
         dao.insertAllSuperheroes(RetrofitInstance.api.getAllSuperheros())
        return RetrofitInstance.api.getAllSuperheros()
    }

    suspend fun loadDataBase(): LiveData<List<SuperheroCharacter>> {
        dao.insertAllSuperheroes(RetrofitInstance.api.getAllSuperheros())
        return dao.getAllSuperherosFromDB()
    }
}





