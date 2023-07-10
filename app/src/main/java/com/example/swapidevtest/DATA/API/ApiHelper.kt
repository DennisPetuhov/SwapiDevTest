package com.example.flowapi.Data.API

import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.DOMAIN.model.PeopleSearchResponse
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.DOMAIN.model.SpaceShipResponse
import com.example.swapidevtest.DOMAIN.model.StarShips
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiHelper {
    fun getPeopleSearch(qwerty: String?): Flow<List<Person>>
    fun getShipSearch(qwerty: String?): Flow<List<StarShips>>

    fun getFilm(id:String): Flow<FilmResponse>
    fun getFilmList(id:MutableList<String>): Flow<MutableList<FilmResponse>>
}