package com.ikigai.rideshare.db.trip

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Trip::class], version = 1, exportSchema = false)
abstract class TripDetailsDatabase : RoomDatabase(){

    abstract fun tripDao(): TripDAO

    companion object {
        @Volatile
        private var INSTANCE: TripDetailsDatabase? = null

        fun getDatabase(context: Context) : TripDetailsDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TripDetailsDatabase::class.java,
                    "tripDetails_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}