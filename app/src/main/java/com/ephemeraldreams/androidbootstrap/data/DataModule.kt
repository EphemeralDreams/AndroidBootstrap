package com.ephemeraldreams.androidbootstrap.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Provides @Singleton
    fun getMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
}
