package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildStarshipAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.databinding.ItemChildListBinding
import com.example.swapidevtest.databinding.ItemStarshipChildBinding
import com.example.swapidevtest.databinding.StarshipViewBinding
import javax.inject.Inject

class ChildStarShipListAdapter @Inject constructor()  :
    ListAdapter<Any, StarshipSublistViewHolder>(
        SubListDiffUtil()
    ) {
    lateinit var binding: ItemStarshipChildBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarshipSublistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemStarshipChildBinding.inflate(inflater, parent, false)
        return StarshipSublistViewHolder(binding)

    }

    override fun onBindViewHolder(holder: StarshipSublistViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindItem(item as String)
    }}

