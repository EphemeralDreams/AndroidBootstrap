package com.ephemeraldreams.androidbootstrap

import com.ephemeraldreams.androidbootstrap.data.DataModule
import com.ephemeraldreams.androidbootstrap.net.NetworkModule
import com.ephemeraldreams.androidbootstrap.ui.ActivityModule
import com.ephemeraldreams.androidbootstrap.ui.FragmentModule
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
        ActivityModule::class,
        FragmentModule::class,
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
