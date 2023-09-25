package com.dk.mvvm.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dk.mvvm.R
import com.dk.mvvm.databinding.ActivityMainBinding
import com.dk.mvvm.model.roomdb.Chinook
import com.dk.mvvm.model.roomdb.ChinookDAO
import com.dk.mvvm.model.roomdb.ChinookDB
import com.dk.mvvm.model.roomdb.ChinookRepository
import com.dk.mvvm.viewmodel.MainViewModel
import com.dk.mvvm.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var mainViewModelFactory: MainViewModelFactory
    lateinit var repository: ChinookRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao = ChinookDB.getDatabase(this).chinookDao()
        repository = ChinookRepository(dao)
        mainViewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this,mainViewModelFactory).get(MainViewModel::class.java)
        mainViewModel.getChinook().observe(this, Observer {
            binding.tvChinook.text = it.toString()
        })

        binding.btnUpdateuserdata.setOnClickListener {
            val chinook = Chinook(0,"test",122)
            mainViewModel.insertChinook(chinook)
        }
        
    }
}
