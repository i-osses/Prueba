package com.prodev.superheros.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.prodev.superheros.R
import com.prodev.superheros.databinding.SuperheroItemBinding
import kotlinx.android.synthetic.main.superhero_item.view.*

class SuperheroAdapter(private val superheroList: List<SuperheroCharacter>) :
    RecyclerView.Adapter<MyViewHolder>() {
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

class MyViewHolder(val binding : SuperheroItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(superheroCharacter: SuperheroCharacter) {
        binding.nameTextView.text = superheroCharacter.name
        binding.idTextView.text = superheroCharacter.id.toString()

    }

}
