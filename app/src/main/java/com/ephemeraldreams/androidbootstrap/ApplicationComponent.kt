package com.ephemeraldreams.androidbootstrap

import com.ephemeraldreams.androidbootstrap.di.DataModule
import com.ephemeraldreams.androidbootstrap.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        DataModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BootstrapApplication> {

    @Component.Factory
    interface Factory {
        fun inject(@BindsInstance application: BootstrapApplication): ApplicationComponent
    }
}
