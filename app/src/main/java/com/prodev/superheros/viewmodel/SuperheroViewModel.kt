package com.prodev.superheros.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prodev.superheros.model.SuperheroCharacter
import com.prodev.superheros.model.SuperheroRepository
import kotlinx.coroutines.launch

class SuperheroViewModel(private val repository: SuperheroRepository) : ViewModel(), Observable {

    val superheros = repository.superheros
    val myResponse: MutableLiveData<List<SuperheroCharacter>> = MutableLiveData()

    @Bindable
    var name = MutableLiveData<String>()

    @Bindable
    var id = MutableLiveData<Int>().toString()



    fun getAllsuperherosFromInternet() {
        viewModelScope.launch {
            val response: List<SuperheroCharacter> = repository.getAllSuperheroes()
            myResponse.value = response
        }
    }
    fun getAllSuperheroesFromDatabase(){
        viewModelScope.launch {
            val responseDB : LiveData<List<SuperheroCharacter>> = repository.loadDataBase()
        }
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

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
