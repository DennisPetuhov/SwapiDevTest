package com.example.swapidevtest.DATA.Repository

import com.example.flowapi.Data.API.ApiHelperImpl
import com.example.swapidevtest.DATA.DB.DatabaseHelperImpl
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.internal.ChannelFlow
import java.nio.channels.Channel
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiHelper: ApiHelperImpl,
    private val databaseHelperImpl: DatabaseHelperImpl

) {

    fun getPeopleSearch(qwerty: String?): Flow<List<CommonItem.Person>> {
        return apiHelper.getPeopleSearch(qwerty)

    }
   fun  getSingleFilmByPersonId(person: CommonItem.Person): Flow<MutableList<FilmResponse>> {
       return apiHelper.getSingleFilmByPersonId(person)
   }

     fun getShipSearch(qwerty: String?): Flow<List<CommonItem.StarShips>> {
        return apiHelper.getShipSearch(qwerty)
    }

    fun getFilmList(listOfFilms:MutableList<String>): Flow<MutableList<FilmResponse>> {
        return apiHelper.getFilmList(listOfFilms)
    }


    fun savePersonToDBFlow(note: PersonEntity) : Flow<Unit> = databaseHelperImpl.insertPersonFlow(note)
//    fun updateNote(note: PersonEntity) = personDao.updatePerson(note)
    fun deleteNote(note: PersonEntity): Flow<Unit> = databaseHelperImpl.deletePerson(note)
//    fun getNote(id: Int): PersonEntity = personDao.getPerson(id)
    fun getAllPeopleFromDB(): Flow<MutableList<PersonEntity>> {
        return databaseHelperImpl.getAllPersons()
        }
    }

