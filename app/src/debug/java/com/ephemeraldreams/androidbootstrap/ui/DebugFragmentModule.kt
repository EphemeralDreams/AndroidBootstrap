package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.settings.DebugSettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DebugFragmentModule : FragmentModule() {
    @ContributesAndroidInjector abstract fun getDebugSettingsFragment(): DebugSettingsFragment
}
