package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.swapidevtest.DOMAIN.model.Person

class MyModelDiffUtill:DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
       return  oldItem==newItem
    }
}