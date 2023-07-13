package com.example.swapidevtest.DOMAIN.UseCase.GetFilmsUseCase

import com.example.swapidevtest.DATA.Repository.Repository
import com.example.swapidevtest.DOMAIN.model.FilmResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(val repository: Repository) {
    fun getFilmListUseCase(listOfFilms: MutableList<String>): Flow<MutableList<FilmResponse>> {
      return  repository.getFilmList(listOfFilms)
    }
}