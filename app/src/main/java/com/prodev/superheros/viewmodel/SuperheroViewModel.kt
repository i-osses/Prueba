package com.prodev.superheros.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prodev.superheros.model.SuperheroCharacter
import com.prodev.superheros.model.SuperheroRepository
import kotlinx.coroutines.launch

class SuperheroViewModel(private val repository: SuperheroRepository) : ViewModel() {

    val myResponse: MutableLiveData<List<SuperheroCharacter>> = MutableLiveData()
    val liveDataFromDB = repository.superheros

    fun getAllsuperheros() {
        viewModelScope.launch {
            val response: List<SuperheroCharacter> = repository.getAllSuperheroes()
            myResponse.value = response
        }
    }


}


/*

class SuperheroViewModel(private val repository: SuperheroRepository) : ViewModel(),
    androidx.databinding.Observable {

    val superheroCharacter = repository.superheros

    @Bindable
    var name = MutableLiveData<String>()

    @Bindable
    var id = MutableLiveData<Int>().toString()

    @Bindable
    var images = MutableLiveData<String>()

*/
