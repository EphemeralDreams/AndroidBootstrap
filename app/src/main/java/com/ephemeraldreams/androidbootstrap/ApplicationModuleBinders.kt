package com.ephemeraldreams.androidbootstrap

import android.app.Application
import com.ephemeraldreams.androidbootstrap.ui.main.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ApplicationModuleBinders {

    @Binds abstract fun provideApplication(bind: BootstrapApplication): Application

    @ContributesAndroidInjector abstract fun provideMainActivity(): MainActivity
}
