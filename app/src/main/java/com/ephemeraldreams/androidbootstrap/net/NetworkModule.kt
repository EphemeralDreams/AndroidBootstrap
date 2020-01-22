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

    @Provides @Singleton
    fun providesOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor(object : Logger {
            override fun log(message: String) {
                if (BuildConfig.DEBUG) {
                    Timber.tag("OkHttp").d(message)
                }
            }
        })
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
}
