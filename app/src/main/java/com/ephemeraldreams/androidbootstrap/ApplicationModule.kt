package com.ephemeraldreams.androidbootstrap

import android.content.Context
import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinders::class])
class ApplicationModule {
    @Provides @Singleton
    fun provideContext(application: BootstrapApplication): Context = application.applicationContext

    @Provides @ApplicationId
    fun provideApplicationId(application: BootstrapApplication): String = application.packageName
}
