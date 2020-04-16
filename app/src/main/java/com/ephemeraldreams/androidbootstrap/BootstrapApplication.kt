package com.ephemeraldreams.androidbootstrap

import android.annotation.SuppressLint
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject
import timber.log.Timber

@SuppressLint("Registered")
open class BootstrapApplication : DaggerApplication() {

    @Inject lateinit var loggingTree: Timber.Tree

    override fun onCreate() {
        super.onCreate()
        Timber.plant(loggingTree)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().inject(this)
    }
}
