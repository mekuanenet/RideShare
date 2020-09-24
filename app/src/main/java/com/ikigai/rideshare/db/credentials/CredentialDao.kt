package com.ikigai.rideshare.db.trip

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TripDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: Trip)

    @Query("SELECT * FROM trip_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Trip>>

    @Update
    suspend fun updateTrip(trip: Trip)

    @Delete
    suspend fun deleteTrip(trip: Trip)

    @Query("DELETE FROM trip_table")
    suspend fun deleteAllTrips()
}