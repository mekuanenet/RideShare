package com.ikigai.rideshare.db.credentials

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credential_table")
data class Credential (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var loginName: String,
    var loginPassword: String
)