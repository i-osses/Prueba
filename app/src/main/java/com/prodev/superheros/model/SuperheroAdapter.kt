package com.prodev.superheros.model

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SuperheroAdapter : RecyclerView.Adapter<SuperheroAdapter.MyViewHolder>(){

    private var superheroList: List<SuperheroCharacter> = ArrayList()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}