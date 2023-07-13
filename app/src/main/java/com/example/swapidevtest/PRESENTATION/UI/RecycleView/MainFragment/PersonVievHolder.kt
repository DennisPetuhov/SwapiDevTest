package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.CommonItem

import com.example.swapidevtest.databinding.PersonViewBinding

class PersonVievHolder(val binding: PersonViewBinding):RecyclerView.ViewHolder(binding.root) {




    fun bindPerson(person: CommonItem.Person){

       binding.namePersonMainFragment.text=person.name
       binding.sex.text=person.gender
       binding.quantityOfStarships.text=person.starships.size.toString()




    }
}


