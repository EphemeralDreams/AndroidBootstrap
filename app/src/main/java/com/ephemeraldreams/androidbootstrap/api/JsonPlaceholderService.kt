package com.ephemeraldreams.androidbootstrap.api

import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {

    @GET("/todos/{id}")
    suspend fun getTodo(@Path("id") id: Int): Todo
}
