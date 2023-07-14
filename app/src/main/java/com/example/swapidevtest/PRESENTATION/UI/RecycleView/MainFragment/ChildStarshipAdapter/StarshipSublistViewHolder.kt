package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildStarshipAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.databinding.ItemStarshipChildBinding

class StarshipSublistViewHolder(val binding: ItemStarshipChildBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindItem(starship: String){
        with(binding){
            subText.text= starship
//            subTextId.text = starship.films.toString()
        }





    }
}