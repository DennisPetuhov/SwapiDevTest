
package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.ChildAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.swapidevtest.DOMAIN.model.FilmResponse


class SubListDiffUtil : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
        return if (oldItem is FilmResponse && newItem is FilmResponse) oldItem.title == newItem.title else false
    }

    override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {

        return if (oldItem is FilmResponse && newItem is FilmResponse) oldItem == newItem else false
    }
}