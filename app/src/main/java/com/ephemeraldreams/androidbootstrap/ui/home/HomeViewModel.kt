package com.ephemeraldreams.androidbootstrap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ephemeraldreams.androidbootstrap.ui.AssistedSavedStateViewModelFactory
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import timber.log.Timber

class HomeViewModel @AssistedInject constructor(
    private val homeRepository: HomeRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory : AssistedSavedStateViewModelFactory<HomeViewModel>

    private val mutableText = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = mutableText

    fun setText(text: String? = null) {
        Timber.d("SavedInstanceState: $savedStateHandle")
        mutableText.value = text ?: homeRepository.applicationId
    }
}
