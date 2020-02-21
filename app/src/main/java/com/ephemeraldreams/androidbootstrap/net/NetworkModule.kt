package com.ephemeraldreams.androidbootstrap.net

import com.ephemeraldreams.androidbootstrap.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Logger
import timber.log.Timber

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : Logger {
            override fun log(message: String) {
                if (BuildConfig.DEBUG) {
                    Timber.tag("OkHttp").d(message)
                }
            }
        })
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        httpLoggingInterceptor.apply {
            redactHeader("Authorization")
            redactHeader("Cookie")
        }
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
}
