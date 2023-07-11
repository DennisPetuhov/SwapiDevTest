package com.example.ui.DATA.Api

import com.example.swapidevtest.DOMAIN.model.FilmResponse
import com.example.swapidevtest.DOMAIN.model.PeopleSearchResponse
import com.example.swapidevtest.DOMAIN.model.SpaceShipResponse
import com.example.swapidevtest.DOMAIN.model.StarShipsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("people")
    suspend fun getPeopleSearch(
        @Query ("search") qwerty :String?): PeopleSearchResponse


//    @GET("/posts")
//    public Call<List<Post>> getPostOfUser(@Query("userId") int id);
//    Поэтому если мы передадим значение 6 в параметре метода, то конечная точка будет следующей — /posts?userId=6

    @GET("starships")
    suspend fun  getShipSearch(  @Query ("search") qwerty :String?): StarShipsResponse

    @GET("films/{id}/")
    suspend fun  getFilm(@Path("id")  id:String ): FilmResponse




}