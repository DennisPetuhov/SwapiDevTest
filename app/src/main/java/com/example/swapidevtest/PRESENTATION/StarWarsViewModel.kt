package com.example.swapidevtest.PRESENTATION

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
class StarWarsViewModel @Inject constructor(private val peopleRepository: PeopleRepository) : ViewModel() {

    val searchPeople: StateFlow<PeopleSearchResponse> get() =_searchPeople
     private var _searchPeople:MutableStateFlow<PeopleSearchResponse> = MutableStateFlow( PeopleSearchResponse())
    fun getPeople() {        viewModelScope.launch(Dispatchers.IO) {
            peopleRepository.getPeopleFromInternet().collect {
                it?.let {
                    _searchPeople.value = it
                }
            }


        }
    }
}