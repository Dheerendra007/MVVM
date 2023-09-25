package com.dk.mvvm.model.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Chinook::class], version = 1)
abstract class ChinookDB: RoomDatabase() {
    abstract fun chinookDao():ChinookDAO
    companion object{
        private var INSTANSE:ChinookDB? = null

        fun getDatabase(context: Context):ChinookDB{
            if(INSTANSE==null){
                synchronized(this){
                    INSTANSE = Room.databaseBuilder(context,ChinookDB::class.java,
                        "chinook").createFromAsset("chinook.db").build()
                }
            }
            return INSTANSE!!
        }
    }
}