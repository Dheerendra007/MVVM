package com.dk.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dk.mvvm.model.roomdb.Chinook
import com.dk.mvvm.model.roomdb.ChinookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val chinookRepository: ChinookRepository):ViewModel() {

    fun getChinook():LiveData<List<Chinook>>{
        return chinookRepository.getChinook()
    }

    fun insertChinook(chinook: Chinook){
        viewModelScope.launch(Dispatchers.IO) {
            chinookRepository.insertChinook(chinook)
        }

    }
}