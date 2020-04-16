package com.ephemeraldreams.androidbootstrap

import com.ephemeraldreams.androidbootstrap.data.DataModule
import com.ephemeraldreams.androidbootstrap.net.NetworkModule
import com.ephemeraldreams.androidbootstrap.ui.ActivityModule
import com.ephemeraldreams.androidbootstrap.ui.DebugFragmentModule
import com.ephemeraldreams.androidbootstrap.util.DebugLoggingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        DebugFragmentModule::class,
        DataModule::class,
        DebugLoggingModule::class,
        NetworkModule::class
    ]
)
interface DebugApplicationComponent : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun inject(@BindsInstance application: BootstrapApplication): DebugApplicationComponent
    }
}
