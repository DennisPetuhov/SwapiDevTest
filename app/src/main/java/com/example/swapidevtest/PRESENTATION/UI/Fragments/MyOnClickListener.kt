package com.example.swapidevtest.PRESENTATION.UI.Fragments

import com.example.swapidevtest.DOMAIN.model.FilmResponse

fun interface  MyOnClickListener{
    fun getFilms(listOfUrl :MutableList<String>):MutableList<FilmResponse>
}