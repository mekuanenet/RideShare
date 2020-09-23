package com.ikigai.rideshare.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "trip_table")
data class Trip (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var departure: String,
    var destination: String,
    var date: String,
    var time: String,
    var no_of_travelers: Int,
    var message: String
)