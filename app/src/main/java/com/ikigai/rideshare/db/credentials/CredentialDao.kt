package com.ikigai.rideshare.db.credentials

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CredentialDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCredential(credent: Credent)

    @Query("SELECT * FROM credential_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Credent>>

    @Update
    suspend fun updateCredential(credent: Credent)

    @Delete
    suspend fun deleteCredential(credent: Credent)

    @Query("DELETE FROM credential_table")
    suspend fun deleteAllCredentials()
}