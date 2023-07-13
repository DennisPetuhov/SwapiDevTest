package com.example.swapidevtest.PRESENTATION.UI.Fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flowapi.Presentation.UI.Base.UiState
import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.UseCase.GetFilmsUseCase.GetFilmsUseCase
import com.example.swapidevtest.DOMAIN.UseCase.PeopleSearchUseCase.PeopleSearchUseCase
import com.example.swapidevtest.DOMAIN.UseCase.StarShipSearchUseCase.StarShipSearchUseCase
import com.example.swapidevtest.DOMAIN.model.CommonItem
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject


val listofFilms = mutableListOf(
    "https://swapi.dev/api/films/1/",
    "https://swapi.dev/api/films/2/",
    " https://swapi.dev/api/films/3/",
    "https://swapi.dev/api/films/6/"
)

@HiltViewModel
class MainViewModel @Inject constructor(
    private val peopleSearchUseCase: PeopleSearchUseCase,
    private val starShipSearchUseCase: StarShipSearchUseCase,
    private val getFilmsUseCase: GetFilmsUseCase
) : ViewModel() {




    init {
//        getPeople()
//        getFilms(listofFilms)
//        getZipList("star")
    }

    val searchZipListState: StateFlow<UiState<MutableList<CommonItem>>> get() = _searchZipList
    private var _searchZipList: MutableStateFlow<UiState<MutableList<CommonItem>>> =
        MutableStateFlow<UiState<MutableList<CommonItem>>>(UiState.Loading)

    fun getZipList(qwerty: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _searchZipList.value = UiState.Loading
            val people = peopleSearchUseCase.getPeopleSearchUseCase(qwerty)
            val starships = starShipSearchUseCase.starShipSearchUseCase(qwerty)

            people.zip(starships) { peopleSearchResponse, starShipsSearchResponse ->
                val list = mutableListOf<CommonItem>()
                list.addAll(peopleSearchResponse)

                list.addAll(starShipsSearchResponse)
//                println("!!! $peopleStarhipsList")
                return@zip list


            }.flowOn(Dispatchers.IO)
                .catch { e ->
                    _searchZipList.value = UiState.Error(e.toString())
                    println("ERROR + $e")
                }
                .collect {
                    _searchZipList.value = UiState.Success(it)

                }
        }
    }

    val searchPeopleState: StateFlow<UiState<List<CommonItem.Person>>> get() = _searchPeopleState
    private var _searchPeopleState =
        MutableStateFlow<UiState<List<CommonItem.Person>>>(UiState.Loading)

    private fun getPeople() {
        viewModelScope.launch(Dispatchers.Main) {
            _searchPeopleState.value = UiState.Loading
            peopleSearchUseCase.getPeopleSearchUseCase("sky")
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _searchPeopleState.value = UiState.Error(e.toString())
                    // handle exception
                }
                .collect {
                    _searchPeopleState.value = UiState.Success(it)
                }
        }
    }


    val searchFilmsState: StateFlow<UiState<MutableList<FilmResponse>>> get() = _searchFilmsState
    private var _searchFilmsState =
        MutableStateFlow<UiState<MutableList<FilmResponse>>>(UiState.Loading)

    fun getFilms(listFilms: MutableList<String>) {
        viewModelScope.launch(Dispatchers.Main) {
            _searchPeopleState.value = UiState.Loading

            getFilmsUseCase.getFilmList(listFilms)
                .flowOn(Dispatchers.IO)
                .catch { e ->
                    _searchFilmsState.value = UiState.Error(e.toString())
                }
                .collect {
                    _searchFilmsState.value = UiState.Success(it)
                }
        }
    }


    fun savePeopleToDb(personEntity: PersonEntity) {
//        saveNote(personEntity)
    }

}