package com.ephemeraldreams.androidbootstrap.util

import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

@Module
object LoggingModule {

    @Provides @Singleton
    fun getTimberTree(): Timber.Tree {
        return CrashReportingTree()
    }

    @Provides @Singleton
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.NONE
            redactHeader("Authorization")
            redactHeader("Cookie")
        }
    }
}
