package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildAdapter

import androidx.recyclerview.widget.RecyclerView
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.databinding.ItemChildListBinding

class SublistViewHolder(val binding: ItemChildListBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindItem(film: FilmResponse){
        with(binding){
            subText.text= film.title
            subTextId.text = film.episode_id.toString()
        }





    }
}