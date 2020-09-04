package com.prodev.superheros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prodev.superheros.databinding.ActivityMainBinding
import com.prodev.superheros.model.SuperheroAdapter
import com.prodev.superheros.model.SuperheroRepository
import com.prodev.superheros.model.db.SuperheroDatabase
import com.prodev.superheros.viewmodel.SuperheroViewModel
import com.prodev.superheros.viewmodel.SuperheroViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mviewModel: SuperheroViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // list = ArrayList()
        //  to get a ViewModel we need a factory. A repository instance need to receive the DAO
        val dao = SuperheroDatabase.getInstance(application).superheroDAO
        val repository = SuperheroRepository(dao)
        val factory = SuperheroViewModelFactory(repository)
        // Now we can access to the ViewModel
        mviewModel = ViewModelProvider(this, factory).get(SuperheroViewModel::class.java)
        binding.myViewModelMain = mviewModel

        binding.lifecycleOwner = this

        initRecyclerView()

        mviewModel.getAllsuperherosFromInternet()
        /*         //      mviewModel.getAllSuperheroesFromDatabase()
            //Coroutines

            mviewModel.myResponse.observe(this, Observer {
                Log.d("TAG", it[0].name)
                //Log.d("Response", response.id.toString())
                Log.d("TAG2", it[1].name)
            })

            mviewModel.superheros.observe(this, Observer {
                Log.d("TAG From DB", it[0].name)
            })*/


    }

    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        displaySuperherosList()
    }

    private fun displaySuperherosList() {

        // with the function getAllSubscribers from the Dao interface we get a LiveData List of superheros
        // We call to the the Dao function from the repository and assign LiveData to the property

        mviewModel.superheros.observe(this, Observer {
            //  Log.i("MYTAG", it.toString())
            // After initRecyclerView function is coded pass the list of subscribers
            binding.myRecyclerView.adapter = SuperheroAdapter(it)
        })
    }
}