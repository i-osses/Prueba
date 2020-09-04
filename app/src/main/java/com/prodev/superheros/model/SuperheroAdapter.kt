package com.prodev.superheros.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prodev.superheros.R
import com.prodev.superheros.databinding.SuperheroItemBinding

class SuperheroAdapter(private val superheroList: List<SuperheroCharacter> = ArrayList()) :
    RecyclerView.Adapter<SuperheroAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: SuperheroItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(superheroCharacter: SuperheroCharacter) {
            binding.nameTextView.text = " Name \n ${superheroCharacter.name}"
            binding.idTextView.text = superheroCharacter.id.toString()
            Glide.with(binding.root)
                .load(superheroCharacter.images.lg)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: SuperheroItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.superhero_item, parent, false)

        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(superheroList[position])



    }

    override fun getItemCount(): Int {
        return superheroList.size
    }
}


