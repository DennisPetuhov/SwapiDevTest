package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.CommonItem

import com.example.swapidevtest.databinding.StarshipViewBinding

class StarShipViewHolder(val binding:StarshipViewBinding):RecyclerView.ViewHolder(binding.root) {
    fun bindStarship(starShips: CommonItem.StarShips){
        with(binding){
            modelOfStarship.text = starShips.model
            nameStarship.text= starShips.name
            pasangers.text=starShips.passengers
            manufacturer.text=starShips.manufacturer

        }

    }
}