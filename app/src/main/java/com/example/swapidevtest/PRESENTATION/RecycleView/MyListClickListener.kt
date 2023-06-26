package com.example.swapidevtest.PRESENTATION.RecycleView

import com.example.swapidevtest.DATA.DB.PersonEntity

interface MyListClickListener {
    fun deletePersonEntity(person : PersonEntity)
}