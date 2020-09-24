package com.ikigai.rideshare.db.trip

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TripViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Trip>>
    private val repository: TripRepository

    init {
        val tripDAO = TripDatabase.getDatabase(application).tripDao()
        repository = TripRepository(tripDAO)
        readAllData = repository.readAllData
    }

    fun addTrip(trip: Trip) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTrip(trip)
        }
    }

    fun updateTrip(trip: Trip){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTrip(trip)
        }
    }

    fun deleteTrip(trip: Trip){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTrip(trip)
        }
    }

    fun deleteAllTrips(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTrips()
        }
    }
}