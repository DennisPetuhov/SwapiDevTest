package com.example.swapidevtest.PRESENTATION.RecycleView.PeopleFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.Person

class MyModelDiffUtill:DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
       return  oldItem==newItem
    }
}