package com.example.swapidevtest.PRESENTATION.RecycleView.FragmentLikes

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DATA.DB.PersonEntity

import com.example.swapidevtest.databinding.PersonViewLikesBinding

class MyModelVievHolder(val binding: PersonViewLikesBinding):RecyclerView.ViewHolder(binding.root) {

//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null


    fun bindTo(person: PersonEntity){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       binding.name.text=person.name
       binding.sex.text=person.sex
        binding.quantityOfStarships.text=person.starShip.size.toString()
        binding.films.text = person.films.size.toString()




    }
}