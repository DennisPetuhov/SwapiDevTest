package com.example.ui.DATA.Api

import com.example.swapidevtest.DOMAIN.model.PeopleSearchResponse
import com.example.swapidevtest.DOMAIN.model.SpaceShipResponse
import retrofit2.http.GET


interface ApiServicePeople {


    @GET("people/?search=sky")
    suspend fun getPeopleSearch(): PeopleSearchResponse

    @GET
    suspend fun  getShip():SpaceShipResponse

}