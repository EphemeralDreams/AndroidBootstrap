package com.ephemeraldreams.androidbootstrap

import com.ephemeraldreams.androidbootstrap.net.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<BootstrapApplication> {

    @Component.Factory
    interface Factory {
        fun inject(@BindsInstance application: BootstrapApplication): ApplicationComponent
    }
}
