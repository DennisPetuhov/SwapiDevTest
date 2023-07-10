package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import android.view.TextureView
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.R
import com.example.swapidevtest.databinding.PersonViewBinding

//class MyModelVievHolder(val binding: PersonViewBinding):RecyclerView.ViewHolder(binding.root) {
//
////    var modelName:TextView = itemView.findViewById(R.id.name)
////    var modelId:TextView = itemView.findViewById(R.id.id)
////    var currentModel:MyModel? = null
//
//
//    fun bindToPerson(person: Person){
////        currentModel=model
////        modelName.text=model.name
////        modelId.text=model.id.toString()
//       binding.name.text=person.name
//       binding.sex.text=person.gender
//       binding.quantityOfStarships.text=person.starships.size.toString()
//
//
//
//
//    }
//}

class MyModelVievHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

//    var modelName:TextView = itemView.findViewById(R.id.name)
//    var modelId:TextView = itemView.findViewById(R.id.id)
//    var currentModel:MyModel? = null
val  name:TextureView = itemView.findViewById(R.id.name_person_main_fragment)

    fun bindToPerson(person: Person){
//        currentModel=model
//        modelName.text=model.name
//        modelId.text=model.id.toString()
       var name =  itemView.findViewById<TextureView>(R.id.name_person_main_fragment)
//        name= person.name
//        binding.name.text=person.name





    }
}



// ViewHolder для элемента списка
//class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val nameTextView: TextView = itemView.findViewById(R.id.dog_name)
//    val ageTextView: TextView = itemView.findViewById(R.id.dog_age)
//    val breedTextView: TextView = itemView.findViewById(R.id.dog_breed)
//}
