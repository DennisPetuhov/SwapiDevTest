package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import com.example.swapidevtest.DATA.DB.PersonEntity
import com.example.swapidevtest.DOMAIN.model.FilmResponse

interface AdPersonToDbAndMakeApiRequest {
    fun getFilms(list: MutableList<String>)
    fun savePeopletoDb( personEntity: PersonEntity)
    fun provideList(list: MutableList<Any>):MutableList<FilmResponse>
}