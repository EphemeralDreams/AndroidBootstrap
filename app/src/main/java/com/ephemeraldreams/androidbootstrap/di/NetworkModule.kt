package com.ephemeraldreams.androidbootstrap.di

import com.ephemeraldreams.androidbootstrap.BuildConfig
import com.ephemeraldreams.androidbootstrap.api.JsonPlaceholderService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Logger
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

@Module
object NetworkModule {

    @Provides @Singleton
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
        httpLoggingInterceptor.redactHeader("Authorization")
        httpLoggingInterceptor.redactHeader("Cookie")
        return httpLoggingInterceptor
    }

    @Provides @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(JsonPlaceholderService.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides @Singleton
    fun provideJsonPlaceholderService(retrofit: Retrofit): JsonPlaceholderService {
        return retrofit.create(JsonPlaceholderService::class.java)
    }
}
