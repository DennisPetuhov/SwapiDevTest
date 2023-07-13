package com.example.swapidevtest.PRESENTATION.UI.RecycleView.FragmentLikes

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonEntity

import com.example.swapidevtest.databinding.PersonViewLikesBinding

class MyModelViewHolder(val binding: PersonViewLikesBinding):RecyclerView.ViewHolder(binding.root) {



    fun bindTo(person: PersonEntity){
       binding.name.text=person.name
       binding.sex.text=person.sex
        binding.quantityOfStarships.text=person.starShip.size.toString()
        binding.films.text = person.films.size.toString()




    }
}