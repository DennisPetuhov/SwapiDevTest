package com.example.flowapi.Data.API

import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse


import kotlinx.coroutines.flow.Flow



interface ApiHelper {
    fun getPeopleSearch(qwerty: String?): Flow<List<CommonItem.Person>>
    fun getShipSearch(qwerty: String?): Flow<List<CommonItem.StarShips>>

    fun getFilm(id:String): Flow<FilmResponse>
    fun getFilmList(id:MutableList<String>): Flow<MutableList<FilmResponse>>
}