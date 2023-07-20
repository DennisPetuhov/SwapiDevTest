package com.example.swapidevtest.PRESENTATION.UI.RecycleView.MainFragment.SAM

import com.example.swapidevtest.DOMAIN.model.CommonItem


fun interface SavePersonToDBFlow {
    fun savePersonToDbFlow(person: CommonItem.Person)
}