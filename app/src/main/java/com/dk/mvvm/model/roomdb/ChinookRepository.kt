package com.dk.mvvm.model.roomdb

import androidx.lifecycle.LiveData

class ChinookRepository(private val chinookDAO: ChinookDAO) {

    fun getChinook():LiveData<List<Chinook>>{
        return chinookDAO.getChinook()
    }

    suspend fun insertChinook(chinook: Chinook){
        chinookDAO.insertChinook(chinook)
    }

    suspend fun deleteChinook(chinook: Chinook){
        chinookDAO.deleteChinook(chinook)
    }
}