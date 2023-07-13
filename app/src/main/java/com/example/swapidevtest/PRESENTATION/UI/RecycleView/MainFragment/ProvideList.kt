package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment

import com.example.swapidevtest.DOMAIN.model.FilmResponse

interface ProvideList {
    fun provideList():MutableList<FilmResponse>

}
