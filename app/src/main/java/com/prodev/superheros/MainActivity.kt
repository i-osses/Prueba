package com.prodev.superheros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.prodev.superheros.model.SuperheroCharacter
import com.prodev.superheros.model.db.SuperheroDatabase
import com.prodev.superheros.model.SuperheroRepository
import com.prodev.superheros.model.network.RetrofitInstance
import com.prodev.superheros.model.network.SuperheroService
import com.prodev.superheros.viewmodel.SuperheroViewModel
import com.prodev.superheros.viewmodel.SuperheroViewModelFactory

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var superheroCharacterViewModel: SuperheroViewModel
    private lateinit var retService: SuperheroService
    private lateinit var list:List<SuperheroCharacter>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = SuperheroDatabase.getInstance(application).superheroDAO
        val repository = SuperheroRepository(dao)
        val factory = SuperheroViewModelFactory(repository)
        superheroCharacterViewModel = ViewModelProvider(this, factory).get(SuperheroViewModel::class.java)
        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(SuperheroCharacter::class.java)
    }


}