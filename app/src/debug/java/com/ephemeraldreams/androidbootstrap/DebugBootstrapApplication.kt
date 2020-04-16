package com.ephemeraldreams.androidbootstrap

import android.annotation.SuppressLint
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

@SuppressLint("Registered")
class DebugBootstrapApplication : BootstrapApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerDebugApplicationComponent.factory().inject(this)
    }
}
