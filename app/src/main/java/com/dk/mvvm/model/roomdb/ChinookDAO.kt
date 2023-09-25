package com.dk.mvvm.model.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ChinookDAO {

    @Insert
    suspend fun insertChinook(chinook: Chinook)

    @Delete
    suspend fun deleteChinook(chinook: Chinook)

    @Query("SELECT * from chinook")
    fun getChinook(): LiveData<List<Chinook>>
}