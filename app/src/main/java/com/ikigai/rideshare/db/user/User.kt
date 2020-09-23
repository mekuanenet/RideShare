package com.ikigai.rideshare.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user_table")
data class User (
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var email: String,
    var password: String
    ): Serializable
    {
        @PrimaryKey(autoGenerate = true)
        val id:Int = 0
    }