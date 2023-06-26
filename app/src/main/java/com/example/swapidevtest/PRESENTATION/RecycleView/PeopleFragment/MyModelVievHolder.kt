package com.example.swapidevtest.PRESENTATION.RecycleView.PeopleFragment

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.databinding.PersonDbBinding
import com.example.swapidevtest.databinding.PersonViewBinding

class MyModelVievHolder(val binding: PersonDbBinding):RecyclerView.ViewHolder(binding.root) {

//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null


    fun bindTo(person: Person){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       binding.name.text=person.name
       binding.sex.text=person.gender
       binding.quantityOfStarships.text=person.starships.size.toString()




    }
}