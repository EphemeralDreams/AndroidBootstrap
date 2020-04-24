package com.ephemeraldreams.androidbootstrap.ui

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
    private val providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>,
    private val factories: Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>>
) {

    /**
     * Create a [AbstractSavedStateViewModelFactory] that handles the creation of a [ViewModel]
     * instance annotated with either [com.squareup.inject.assisted.AssistedInject] or [Inject]
     * constructor and pass it the dependencies it needs.
     */
    fun create(owner: SavedStateRegistryOwner, defaultArgs: Bundle? = null) =
        object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
            override fun <T : ViewModel?> create(
                key: String,
                modelClass: Class<T>,
                handle: SavedStateHandle
            ): T {
                val viewModel = createAssistedViewModel(modelClass, handle)
                    ?: createViewModel(modelClass)
                    ?: throw IllegalArgumentException("Unknown model class $modelClass")
                try {
                    return viewModel
                } catch (exception: Exception) {
                    throw RuntimeException(exception)
                }
            }
        }

    /**
     * Create a [ViewModel] instance annotated with [com.squareup.inject.assisted.AssistedInject]
     * constructor and pass it the dependencies it needs.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T : ViewModel?> createAssistedViewModel(
        modelClass: Class<T>,
        savedStateHandle: SavedStateHandle
    ): T? {
        val creator = factories[modelClass]
            ?: factories.entries.firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
            ?: return null
        return creator.create(savedStateHandle) as T
    }

    /**
     * Create a [ViewModel] instance annotated with [Inject] constructor and pass it the
     * dependencies it needs.
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T : ViewModel?> createViewModel(modelClass: Class<T>): T? {
        val creator = providers[modelClass]
            ?: providers.entries.firstOrNull { modelClass.isAssignableFrom(it.key) }?.value
            ?: return null
        return creator.get() as T
    }
}

interface AssistedSavedStateViewModelFactory<T : ViewModel> {
    fun create(savedStateHandle: SavedStateHandle): T
}
