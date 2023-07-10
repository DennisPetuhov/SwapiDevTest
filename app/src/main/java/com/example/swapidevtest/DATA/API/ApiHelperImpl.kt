package com.example.flowapi.Data.API

import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.DOMAIN.model.PeopleSearchResponse
import com.example.swapidevtest.DOMAIN.model.Person
import com.example.swapidevtest.DOMAIN.model.SpaceShipResponse
import com.example.swapidevtest.DOMAIN.model.StarShips
import com.example.ui.DATA.Api.ApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {


    override fun getPeopleSearch(qwerty: String?): Flow<List<Person>> {
        return flow {
            val response = apiService.getPeopleSearch(qwerty).people
            response?.let {
                emit(it)
            }
        }

    }

    override fun getShipSearch(qwerty: String?): Flow<List<StarShips>> {
        return flow { val result =apiService.getShipSearch(qwerty).results
            emit(result) }
    }

    override fun getFilm(id: String): Flow<FilmResponse> {
        return flow { emit(apiService.getFilm(id)) }
    }

    override fun getFilmList(listOfFilms: MutableList<String>): Flow<MutableList<FilmResponse>> {

        return flow {
            val list = mutableListOf<FilmResponse>()
            for (film in listOfFilms) {
                val id = film.filter { it.isDigit() }
                val responce = apiService.getFilm(id)
                list.add(responce)

            }
            emit(list)
        }

    }
}