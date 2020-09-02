package com.prodev.superheros.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prodev.superheros.model.SuperheroRepository
import java.lang.IllegalArgumentException

class SuperheroViewModelFactory(private val repository: SuperheroRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SuperheroViewModel::class.java)){
            return SuperheroViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}