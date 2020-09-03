package com.prodev.superheros.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prodev.superheros.model.network.SuperheroService
import retrofit2.Response

@Entity(tableName = "superhero_data_table")
data class SuperheroCharacter (

    @PrimaryKey
    @ColumnInfo(name = "superhero_id")
    val id : Int,
    @ColumnInfo(name ="superhero_name")
    val name : String,
    @Embedded val images : Images
)

