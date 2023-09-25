package com.dk.mvvm.model.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chinook")
data class Chinook(
    @PrimaryKey(autoGenerate = true)
    val cutomerID:Int,
    val firstname:String,
    val lastname:Int
)