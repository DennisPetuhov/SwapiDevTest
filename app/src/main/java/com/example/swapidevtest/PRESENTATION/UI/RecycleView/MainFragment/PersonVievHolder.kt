package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.CommonItem

import com.example.swapidevtest.databinding.PersonViewBinding

class PersonVievHolder(val binding: PersonViewBinding):RecyclerView.ViewHolder(binding.root) {

//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null


    fun bindPerson(person: CommonItem.Person){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       binding.namePersonMainFragment.text=person.name
       binding.sex.text=person.gender
       binding.quantityOfStarships.text=person.starships.size.toString()




    }
}


