package com.ephemeraldreams.androidbootstrap.ui

import androidx.lifecycle.ViewModel
import com.ephemeraldreams.androidbootstrap.annotations.ViewModelKey
import com.ephemeraldreams.androidbootstrap.ui.dashboard.DashboardViewModel
import com.ephemeraldreams.androidbootstrap.ui.home.HomeViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.Multibinds

@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
abstract class ViewModelModule {

    @Multibinds
    abstract fun bindViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>

    @Multibinds
    abstract fun bindAssistedViewModels(): Map<Class<out ViewModel>, @JvmSuppressWildcards AssistedSavedStateViewModelFactory<out ViewModel>>

    @Binds @IntoMap @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModelFactory: HomeViewModel.Factory): AssistedSavedStateViewModelFactory<out ViewModel>

    @Binds @IntoMap @ViewModelKey(DashboardViewModel::class)
    abstract fun bindDashboardViewModel(dashboardViewModel: DashboardViewModel): ViewModel
}
