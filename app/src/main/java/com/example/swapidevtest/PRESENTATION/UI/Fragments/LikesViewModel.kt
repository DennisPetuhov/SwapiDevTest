package com.example.swapidevtest.PRESENTATION.UI.Fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DATA.Repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LikesViewModel @Inject constructor(private val peopleRepository: Repository) :
    ViewModel() {


    val listOfPeople: StateFlow<MutableList<PersonEntity>> get() = _listOfPeople
    private var _listOfPeople: MutableStateFlow<MutableList<PersonEntity>> =
        MutableStateFlow(mutableListOf(PersonEntity()))

    fun getPeopleFromDB() {
        viewModelScope.launch(Dispatchers.Main) {
            peopleRepository.getAllPeopleFromDB().collect {
                it?.let {
                    println(it)
                    _listOfPeople.value = it
                }
            }


        }
    }

    fun deletePersonEntity(person: PersonEntity) {
        viewModelScope.launch {
            peopleRepository.deleteNote(person).flatMapConcat {
                flow { emit(person) }
            }.flowOn(Dispatchers.IO).collect {}
        }
    }


    fun updateList(): Flow<MutableList<PersonEntity>> {
        return peopleRepository.getAllPeopleFromDB()
    }
}
