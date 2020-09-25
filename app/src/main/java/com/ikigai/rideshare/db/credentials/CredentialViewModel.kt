package com.ikigai.rideshare.db.credentials

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CredentialViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Credent>>
    private val repository: CredentialRepository

    init {
        val credentialDao = CredentialDatabase.getDatabase(application).credentialDao()
        repository = CredentialRepository(credentialDao)
        readAllData = repository.readAllData
    }

    fun addCredential(credent: Credent) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCredential(credent)
        }
    }

    fun updateCredential(credent: Credent){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCredential(credent)
        }
    }

    fun deleteCredential(credent: Credent){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCredential(credent)
        }
    }

    fun deleteAllCredential(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCredential()
        }
    }
}