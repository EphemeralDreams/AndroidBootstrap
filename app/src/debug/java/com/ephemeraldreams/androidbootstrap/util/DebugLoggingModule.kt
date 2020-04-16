package com.ephemeraldreams.androidbootstrap.util

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Logger
import timber.log.Timber

@Module
object DebugLoggingModule {

    @Provides @Singleton
    fun getTimberTree(): Timber.Tree {
        return Timber.DebugTree()
    }

    @Provides @Singleton
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : Logger {
            override fun log(message: String) {
                Timber.tag("OkHttp").d(message)
            }
        })
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return httpLoggingInterceptor
    }
}
