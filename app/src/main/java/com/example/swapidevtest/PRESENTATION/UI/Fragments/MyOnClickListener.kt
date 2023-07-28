package com.example.swapidevtest.PRESENTATION.UI.Fragments

import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import kotlinx.coroutines.flow.Flow

fun interface  MyOnClickListener{

  fun getSingleFilmByPersonId(person: CommonItem.Person)
}