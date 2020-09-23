package com.ikigai.rideshare.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TripDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: Trip)

    @Query("SELECT * FROM trip_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Trip>>
}