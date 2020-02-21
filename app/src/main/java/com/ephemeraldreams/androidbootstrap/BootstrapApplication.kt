package com.ephemeraldreams.androidbootstrap

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

class BootstrapApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().inject(this)
    }
}
