package com.prodev.superheros.model.network

import com.prodev.superheros.model.SuperheroCharacter
import retrofit2.Response
import retrofit2.http.GET

interface SuperheroService {
    @GET("all.json")
    suspend fun getAllSuperheros() : List<SuperheroCharacter>


}
