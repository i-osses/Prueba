package com.prodev.superheros.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.prodev.superheros.model.SuperheroCharacter

@Dao
interface SuperheroDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSuperheroes(SuperheroList:List<SuperheroCharacter>)

    @Query("SELECT * FROM superhero_data_table")
    fun getAllSuperherosFromDB(): LiveData<List<SuperheroCharacter>>

    @Query("DELETE FROM superhero_data_table")
    fun deleteAll() : Int


}