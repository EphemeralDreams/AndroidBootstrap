package com.ephemeraldreams.androidbootstrap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val mutableText = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = mutableText
}
