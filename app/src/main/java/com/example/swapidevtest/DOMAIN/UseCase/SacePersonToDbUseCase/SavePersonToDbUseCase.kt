package com.example.swapidevtest.DOMAIN.UseCase.SacePersonToDbUseCase

import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DATA.Repository.Repository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class SavePersonToDbUseCase @Inject constructor(private val repository: Repository) {
    fun savePersonToDbUseCase(personEntity: PersonEntity): Flow<Unit> {
      return  repository.savePersonToDBFlow(personEntity)
    }
}