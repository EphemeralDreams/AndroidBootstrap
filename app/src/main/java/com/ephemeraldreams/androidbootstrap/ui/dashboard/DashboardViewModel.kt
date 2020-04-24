package com.ephemeraldreams.androidbootstrap.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DashboardViewModel @Inject constructor() : ViewModel() {

    private val mutableText = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = mutableText
}
