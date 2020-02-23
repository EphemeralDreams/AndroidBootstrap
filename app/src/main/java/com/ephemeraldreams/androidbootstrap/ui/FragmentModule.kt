package com.ephemeraldreams.androidbootstrap.ui

import com.ephemeraldreams.androidbootstrap.ui.placeholder.PlaceholderFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector abstract fun providePlaceholderFragment(): PlaceholderFragment
}
