package com.dk.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dk.mvvm.model.roomdb.Chinook
import com.dk.mvvm.model.roomdb.ChinookRepository


class MainViewModelFactory(private val  chinookRepository: ChinookRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(chinookRepository) as T
    }
}