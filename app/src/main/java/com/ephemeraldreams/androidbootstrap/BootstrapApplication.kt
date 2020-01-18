package com.ephemeraldreams.androidbootstrap

import android.app.Application
import timber.log.Timber

class BootstrapApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
