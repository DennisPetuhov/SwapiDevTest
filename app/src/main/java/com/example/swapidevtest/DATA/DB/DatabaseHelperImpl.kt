package com.example.swapidevtest.DATA.DB

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DatabaseHelperImpl @Inject constructor(private val personDatabase: PersonDatabase) : DatabaseHelper {


    override fun getAllPersons(): Flow<MutableList<PersonEntity>> {
        return flow {
            emit(personDatabase.personDao().getAllPersons())
        }

    }

    override fun insertPersonFlow(personEntity: PersonEntity): Flow<Unit> {
        return flow { personDatabase.personDao().insertPersonFlow(personEntity)
        emit(Unit)}
    }

    override suspend fun insertPerson(personEntity: PersonEntity) {
        personDatabase.personDao().insertPerson(personEntity)
    }

}