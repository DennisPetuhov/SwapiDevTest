package com.example.swapidevtest.DOMAIN.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilmResponse(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    val episode_id: Int,
    val opening_crawl: String,
    val planets: List<String>,
    val producer: String,
    val release_date: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
):Parcelable