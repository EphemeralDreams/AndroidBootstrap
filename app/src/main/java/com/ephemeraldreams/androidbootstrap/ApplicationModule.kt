package com.ephemeraldreams.androidbootstrap

import android.app.Application
import android.content.Context
import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinders::class])
object ApplicationModule {
    @Provides @Singleton
    fun provideContext(application: BootstrapApplication): Context = application.applicationContext

    @Provides @ApplicationId
    fun provideApplicationId(application: BootstrapApplication): String = application.packageName
}

@Module
abstract class ApplicationModuleBinders {

    @Binds
    abstract fun provideApplication(bind: BootstrapApplication): Application
}
