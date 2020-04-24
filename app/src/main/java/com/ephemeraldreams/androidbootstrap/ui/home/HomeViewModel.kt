package com.ephemeraldreams.androidbootstrap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    private val mutableText = MutableLiveData<String>().apply {
        value = homeRepository.applicationId
    }
    val text: LiveData<String> = mutableText
}
