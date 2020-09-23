package com.ikigai.rideshare.db

import androidx.lifecycle.LiveData

class TripRepository(private val tripDAO: TripDAO) {

    val readAllData: LiveData<List<Trip>> = tripDAO.readAllData()

    suspend fun addTrip(trip: Trip) {
        tripDAO.addTrip(trip)
    }
}