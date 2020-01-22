package com.ephemeraldreams.androidbootstrap

import android.app.Application
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModuleBinders {

    @Binds abstract fun provideApplication(bind: BootstrapApplication): Application
}
