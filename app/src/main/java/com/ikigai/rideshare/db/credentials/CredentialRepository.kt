package com.ikigai.rideshare.db.credentials

import androidx.lifecycle.LiveData

class CredentialRepository(private val credentialDao: CredentialDao) {

    val readAllData: LiveData<List<Credent>> = credentialDao.readAllData()

    suspend fun addCredential(credent: Credent) {
        credentialDao.addCredential(credent)
    }

    suspend fun updateCredential(credent: Credent){
        credentialDao.updateCredential(credent)
    }

    suspend fun deleteCredential(credent: Credent){
        credentialDao.deleteCredential(credent)
    }

    suspend fun deleteAllCredential(){
        credentialDao.deleteAllCredentials()
    }
}