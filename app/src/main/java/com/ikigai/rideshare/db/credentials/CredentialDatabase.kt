package com.ikigai.rideshare.db.credentials

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Credent::class], version = 1, exportSchema = false)
abstract class CredentialDatabase : RoomDatabase(){

    abstract fun credentialDao(): CredentialDao

    companion object {
        @Volatile
        private var INSTANCE: CredentialDatabase? = null

        fun getDatabase(context: Context) : CredentialDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CredentialDatabase::class.java,
                    "credential_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}