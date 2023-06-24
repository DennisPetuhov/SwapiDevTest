package com.example.listadapyter

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.databinding.PersonViewBinding

class MyModelVievHolder(val binding: PersonViewBinding):RecyclerView.ViewHolder(binding.root) {
//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null

    fun bindTo(person: Person){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       binding.name.text=person.name.toString()
       binding.sex.text=person.gender.toString()
       binding.quantityOfStarships.text=person.starships.toString()



    }
}