package com.prodev.superheros.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prodev.superheros.model.network.SuperheroService
import retrofit2.Response

@Entity(tableName = "superhero_data_table")
data class SuperheroCharacter (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "superhero_id")
    val id : Int,
    @ColumnInfo(name ="superhero_name")
    val name : String,
    @ColumnInfo(name = "images_urls")
    val images : String
)

