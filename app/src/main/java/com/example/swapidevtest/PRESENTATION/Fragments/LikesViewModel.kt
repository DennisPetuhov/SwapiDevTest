package com.example.swapidevtest.PRESENTATION.Fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapidevtest.DATA.Repository.PeopleRepository
import com.example.swapidevtest.DOMAIN.model.PeopleSearchResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LikesViewModel @Inject constructor(private val peopleRepository: PeopleRepository) : ViewModel() {




val listOfPeople: StateFlow<PeopleSearchResponse> get() = _listOfPeople
private var _listOfPeople: MutableStateFlow<PeopleSearchResponse> =
    MutableStateFlow(PeopleSearchResponse())

fun getPeopleFromDB() {
    viewModelScope.launch(Dispatchers.Main) {
        peopleRepository.getAllPeopleFromDB().collect {
            it?.let {
               println(it)
            }
        }


    }}}

//
//    val list = dao.getAllPersons()
//    println(list)