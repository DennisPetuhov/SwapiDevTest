package com.example.swapidevtest.DATA.Repository

import com.example.flowapi.Data.API.ApiHelperImpl
import com.example.swapidevtest.DATA.DB.PersonDao
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val personDao: PersonDao,
    private val apiHelper: ApiHelperImpl

) {

    fun getPeopleSearch(qwerty: String?): Flow<List<CommonItem.Person>> {
        return apiHelper.getPeopleSearch(qwerty)

    }

     fun getShipSearch(qwerty: String?): Flow<List<CommonItem.StarShips>> {
        return apiHelper.getShipSearch(qwerty)
    }

    fun getFilmList(listOfFilms:MutableList<String>): Flow<MutableList<FilmResponse>> {
        return apiHelper.getFilmList(listOfFilms)
    }


    fun saveNote(note: PersonEntity) = personDao.insertPerson(note)
    fun updateNote(note: PersonEntity) = personDao.updatePerson(note)
    fun deleteNote(note: PersonEntity) = personDao.deletePerson(note)
    fun getNote(id: Int): PersonEntity = personDao.getPerson(id)
    fun getAllPeopleFromDB(): Flow<MutableList<PersonEntity>> {
        return flow {
            val list = personDao.getAllPersons()
            emit(list)
        }
    }
}
