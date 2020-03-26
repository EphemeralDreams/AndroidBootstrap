package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.dashboard.DashboardFragment
import com.ephemeraldreams.androidbootstrap.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector abstract fun getHomeFragment(): HomeFragment
    @ContributesAndroidInjector abstract fun getDashboardFragment(): DashboardFragment
}
