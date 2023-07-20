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

//    fun deletePersonEntity(person:PersonEntity){
//        peopleRepository.deleteNote(person)
//    }
    fun updateList(): Flow<MutableList<PersonEntity>> {
        return peopleRepository.getAllPeopleFromDB()
    }
}

//
//    val list = dao.getAllPersons()
//    println(list)