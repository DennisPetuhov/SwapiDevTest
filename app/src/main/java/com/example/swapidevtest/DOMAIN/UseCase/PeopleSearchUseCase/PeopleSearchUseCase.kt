package com.example.swapidevtest.DOMAIN.UseCase.PeopleSearchUseCase

import com.example.swapidevtest.DATA.Repository.Repository
import com.example.swapidevtest.DOMAIN.model.Person
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PeopleSearchUseCase @Inject constructor(val repository: Repository) {
    fun getPeopleSearchUseCase( qwerty:String): Flow<List<Person>>{
      return  repository.getPeopleSearch(qwerty)
    }

}