package com.prodev.superheros

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.prodev.superheros.model.SuperheroCharacter
import com.prodev.superheros.model.SuperheroRepository
import com.prodev.superheros.model.db.SuperheroDatabase
import com.prodev.superheros.model.network.SuperheroService
import com.prodev.superheros.viewmodel.SuperheroViewModel
import com.prodev.superheros.viewmodel.SuperheroViewModelFactory

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var mviewModel: SuperheroViewModel
    private lateinit var retService: SuperheroService
    private lateinit var list: List<SuperheroCharacter>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        list = ArrayList()
        // to get a ViewModel we need a factory. A repository instance need to receive the DAO
        val dao = SuperheroDatabase.getInstance(application).superheroDAO
        val repository = SuperheroRepository(dao)
        val factory = SuperheroViewModelFactory(repository)
        // Now we van access to the ViewModel
        mviewModel = ViewModelProvider(this, factory).get(SuperheroViewModel::class.java)
        //mviewModel.getAllsuperheros()
        //Coroutines

       mviewModel.myResponse.observe(this, Observer {
            Log.d("TAG", it[0].name)
            //Log.d("Response", response.id.toString())
            Log.d("TAG2", it[1].name)
        })

        mviewModel.liveDataFromDB.observe(this, Observer{
            Log.d("TAG From DB", it[0].name)
        })

        }



    suspend fun loadData(){

    }
}


