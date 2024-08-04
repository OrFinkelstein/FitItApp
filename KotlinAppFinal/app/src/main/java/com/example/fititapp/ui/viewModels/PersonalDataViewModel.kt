package com.example.fititapp.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import kotlinx.coroutines.launch
import androidx.lifecycle.viewModelScope
import com.example.fititapp.data.models.PersonalData
import com.example.fititapp.data.repostories.PersonalDataRepository

class PersonalDataViewModel(application: Application)
    : AndroidViewModel(application) {

    private val repository = PersonalDataRepository(application)

    val personalData: LiveData<PersonalData>? = repository.getOnlyItem()

    private val _chosenItem = MutableLiveData<PersonalData>()
    val chosenItem: LiveData<PersonalData> get() = _chosenItem

    fun setItem(item: PersonalData) {
        _chosenItem.value = item
    }

    fun getOnlyPerson() : LiveData<PersonalData>? {
        return personalData
    }

    fun addItem(item: PersonalData) {
        viewModelScope.launch {
            repository.addItem(item)
        }
    }

    fun deleteItem(item: PersonalData) {
        viewModelScope.launch {
            repository.deleteItem(item)
        }
    }

    fun deleteAll() {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }

}
