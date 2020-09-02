package com.prodev.superheros

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.prodev.superheros.model.SuperheroCharacter
import com.prodev.superheros.model.db.SuperheroDatabase
import com.prodev.superheros.model.SuperheroRepository
import com.prodev.superheros.model.network.SuperheroService
import com.prodev.superheros.viewmodel.SuperheroViewModel
import com.prodev.superheros.viewmodel.SuperheroViewModelFactory
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    private lateinit var mviewModel: SuperheroViewModel
    private lateinit var retService: SuperheroService
    private lateinit var list:List<SuperheroCharacter>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        list= ArrayList()

        val dao = SuperheroDatabase.getInstance(application).superheroDAO
        val repository = SuperheroRepository(dao)
        val factory = SuperheroViewModelFactory(repository)
        mviewModel =
            ViewModelProvider(this, factory).get(SuperheroViewModel::class.java)

        mviewModel.getAllsuperheros()
        //Coroutines
        mviewModel.myResponse.observe(this, Observer {
          Log.d("TAG", it[0].name )
            //Log.d("Response", response.id.toString())

        })
    }
}


