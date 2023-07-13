package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.databinding.ItemChildListBinding
import javax.inject.Inject

class ChildListAdapter @Inject constructor()  :
    ListAdapter<Any, SublistViewHolder>(
        SubListDiffUtil()
    ) {
    lateinit var binding: ItemChildListBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SublistViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemChildListBinding.inflate(inflater, parent, false)
        return SublistViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SublistViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindItem(item as FilmResponse)
    }}

