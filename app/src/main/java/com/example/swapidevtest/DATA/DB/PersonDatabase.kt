package com.example.swapidevtest.DATA.DB

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(entities = [PersonEntity::class], version = 1)
abstract class PersonDatabase:RoomDatabase(){
    abstract fun  personDao():PersonDao
}