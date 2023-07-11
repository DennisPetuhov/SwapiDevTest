package com.example.swapidevtest.PRESENTATION.UI.RecycleView.FragmentLikes

import androidx.recyclerview.widget.DiffUtil
import com.example.swapidevtest.DATA.DB.PersonEntity


class MyModelDiffUtill:DiffUtil.ItemCallback<PersonEntity>() {
    override fun areItemsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return  oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
       return  oldItem==newItem
    }
}