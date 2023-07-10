package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import com.example.swapidevtest.DATA.DB.PersonEntity

interface AdPersonToDbAndMakeApiRequest {
    fun getFilms()
    fun savePeopletoDb( personEntity: PersonEntity)
}