package com.ephemeraldreams.androidbootstrap.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class TodoRepository {

    val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build())
            )
            .build()
            .create(JsonPlaceholderService::class.java)
    }

    suspend fun getTodo(id: Int) = webService.getTodo(id)
}
