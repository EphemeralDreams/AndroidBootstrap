package com.ephemeraldreams.androidbootstrap

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject
import okhttp3.OkHttpClient
import timber.log.Timber

class BootstrapApplication : DaggerApplication() {

    @Inject lateinit var okHttpClient: OkHttpClient

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
