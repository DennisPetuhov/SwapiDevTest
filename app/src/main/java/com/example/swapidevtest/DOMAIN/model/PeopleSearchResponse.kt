package com.example.swapidevtest.DOMAIN.model

import android.os.Parcelable
import androidx.room.Ignore
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PeopleSearchResponse(
    val count: Int? = null,
    val next: String? = null,
    val previous: String? = null,
    @Json(name = "results")
    val people: List<Person>? = null
) : Parcelable

@Parcelize
data class Person(
    val name: String,
    val starships: List<String>,
    val gender: String,
    @Ignore
    val birth_year: String,
    @Ignore
    val created: String,
    @Ignore
    val edited: String,
    @Ignore
    val eye_color: String,
    @Ignore
    val films: List<String>,
    @Ignore
    val hair_color: String,
    @Ignore
    val height: String,
    @Ignore
    val homeworld: String,
    @Ignore
    val mass: String,
    @Ignore
    val skin_color: String,
    @Ignore
    val species: List<String>,
    @Ignore
    val url: String,
    @Ignore
    val vehicles: List<String>
) : Parcelable