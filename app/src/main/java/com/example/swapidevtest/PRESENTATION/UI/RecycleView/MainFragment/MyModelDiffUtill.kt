package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.swapidevtest.DOMAIN.model.CommonItem


class MyModelDiffUtill:DiffUtil.ItemCallback<CommonItem>() {
    override fun areItemsTheSame(oldItem: CommonItem, newItem: CommonItem): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: CommonItem, newItem: CommonItem): Boolean {
       return  oldItem==newItem
    }
}