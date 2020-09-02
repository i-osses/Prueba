package com.prodev.superheros.viewmodel
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prodev.superheros.model.SuperheroRepository

class SuperheroViewModel(private val repository: SuperheroRepository) : ViewModel(),
    androidx.databinding.Observable {

    val superheroCharacter = repository.superheros

    @Bindable
    var name = MutableLiveData<String>()

    @Bindable
    var id = MutableLiveData<Int>().toString()

    @Bindable
    var images = MutableLiveData<String>()
    override fun addOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: androidx.databinding.Observable.OnPropertyChangedCallback?) {

    }


}