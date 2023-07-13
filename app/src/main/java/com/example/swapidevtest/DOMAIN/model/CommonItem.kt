package com.example.swapidevtest.DOMAIN.model

import android.os.Parcelable
import androidx.room.Ignore

import com.example.swapidevtest.DOMAIN.model.ItemType.TYPE_PERSON

import com.example.swapidevtest.DOMAIN.model.ItemType.TYPE_STARSHIP
import kotlinx.parcelize.Parcelize

sealed class CommonItem {
    abstract val viewType: Int

    @Parcelize
    data class Person(
        val name: String,
        val starships: List<String>,
        val gender: String,
        @Ignore
        val birth_year: String,
        @Ignore
        val created: String,
        @Ignore
        val edited: String,
        @Ignore
        val eye_color: String,
        @Ignore
        val films: List<String>,
        @Ignore
        val hair_color: String,
        @Ignore
        val height: String,
        @Ignore
        val homeworld: String,
        @Ignore
        val mass: String,
        @Ignore
        val skin_color: String,
        @Ignore
        val species: List<String>,
        @Ignore
        val url: String,
        @Ignore
        val vehicles: List<String>,
        override val viewType: Int = TYPE_PERSON

    ) : CommonItem(), Parcelable

    @Parcelize
    data class StarShips(
        val MGLT: String,
        val cargo_capacity: String,
        val consumables: String,
        val cost_in_credits: String,
        val created: String,
        val crew: String,
        val edited: String,
        val films: List<String>,
        val hyperdrive_rating: String,
        val length: String,
        val manufacturer: String,
        val max_atmosphering_speed: String,
        val model: String,
        val name: String,
        val passengers: String,
        val pilots: List<String>,
        val starship_class: String,
        val url: String,
        override val viewType: Int = TYPE_STARSHIP

    ) : CommonItem(), Parcelable





}
