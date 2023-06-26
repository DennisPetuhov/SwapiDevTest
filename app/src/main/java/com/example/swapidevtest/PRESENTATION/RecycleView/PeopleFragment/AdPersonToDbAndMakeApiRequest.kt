package com.example.swapidevtest.PRESENTATION.RecycleView.PeopleFragment

import com.example.swapidevtest.DATA.DB.PersonEntity

interface AdPersonToDbAndMakeApiRequest {
    fun getFilms()
    fun savePeopletoDb( personEntity: PersonEntity)
}