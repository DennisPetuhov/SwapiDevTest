package com.example.swapidevtest.DOMAIN.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StarShipsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<CommonItem.StarShips>
) : Parcelable

