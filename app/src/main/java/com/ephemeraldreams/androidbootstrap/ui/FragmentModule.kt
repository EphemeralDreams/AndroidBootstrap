package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.dashboard.DashboardFragment
import com.ephemeraldreams.androidbootstrap.ui.home.HomeFragment
import com.ephemeraldreams.androidbootstrap.ui.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector abstract fun getHomeFragment(): HomeFragment
    @ContributesAndroidInjector abstract fun getDashboardFragment(): DashboardFragment
    @ContributesAndroidInjector abstract fun getSettingsFragment(): SettingsFragment
}
