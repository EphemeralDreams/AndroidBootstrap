package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector abstract fun provideHomeActivity(): HomeActivity
}
