package com.example.swapidevtest.PRESENTATION.UI.RecycleView

import com.example.swapidevtest.DATA.DB.PersonEntity

interface MyListClickListener {
    fun deletePersonEntity(person : PersonEntity)
}