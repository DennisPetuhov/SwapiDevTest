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
    val people: List<CommonItem.Person>? = null
) : Parcelable

