package com.example.swapidevtest.DATA.DB

import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    fun getAllPersons(): Flow<MutableList<PersonEntity>>

    fun insertPersonFlow(personEntity: PersonEntity): Flow<Unit>
   suspend fun insertPerson(personEntity: PersonEntity)


}