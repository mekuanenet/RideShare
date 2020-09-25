package com.ikigai.rideshare.db.trip

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime

@Parcelize
@Entity(tableName = "tripDetails_table")
data class Trip (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var poster: String,
    var departure: String,
    var destination: String,
    var date: String,
    var time: String,
    var no_of_travelers: String,
    var message: String,
    var email: String,
    var phone: String
): Parcelable