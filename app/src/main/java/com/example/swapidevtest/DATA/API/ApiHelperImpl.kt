package com.example.flowapi.Data.API

import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.ui.DATA.Api.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.internal.ChannelFlow
import java.nio.channels.Channel
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {


    override fun getPeopleSearch(qwerty: String?): Flow<List<CommonItem.Person>> {
        return flow {
            val response = apiService.getPeopleSearch(qwerty).people

            response?.let {

                emit(it)
            }
        }

    }


    override fun getSingleFilmByPersonId(person: CommonItem.Person): Flow<MutableList<FilmResponse>> {
        return flow {
            val listOfFilms = person.films
            val newListOfFilms = mutableListOf<FilmResponse>()
            for (film in listOfFilms) {
                val id = film.filter { it.isDigit() }
                val filmResponse = apiService.getFilm(id)
                newListOfFilms.add(filmResponse)
                println("~~~~"+ filmResponse.title)

            }
           emit( newListOfFilms)
        }

    }

    override fun getShipSearch(qwerty: String?): Flow<List<CommonItem.StarShips>> {
        return flow {
            val result = apiService.getShipSearch(qwerty).results
            result?.let { listOfStarShips ->
                for (element in listOfStarShips) {
                    val listOfFilms = element.films
                    for (film in listOfFilms) {
                        val id = film.filter { it.isDigit() }
                        val filmResponse = apiService.getFilm(id)
                        element.listOfFilmResponse.add(filmResponse)
                    }


                }

            }
            result.let {

                emit(it)
            }
        }
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