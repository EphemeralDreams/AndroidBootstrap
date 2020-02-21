package com.ephemeraldreams.androidbootstrap.api

import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }

    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): Todo
}
