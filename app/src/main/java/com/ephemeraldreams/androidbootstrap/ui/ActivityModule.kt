package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.home.HomeActivity
import com.ephemeraldreams.androidbootstrap.ui.settings.SettingsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector abstract fun provideHomeActivity(): HomeActivity
    @ContributesAndroidInjector abstract fun provideSettingsActivity(): SettingsActivity
}
