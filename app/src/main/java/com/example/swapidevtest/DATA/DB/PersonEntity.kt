package com.example.swapidevtest.DATA.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.swapidevtest.DATA.DB.Constants.PERSON_TABLE


@Entity(tableName = PERSON_TABLE)
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val personId: Int = 0,
    val name: String= "",
    @ColumnInfo(name = "sex")
    val sex: String = "",
    @ColumnInfo(name = "star_ship")
    val starShip: String = ""
)