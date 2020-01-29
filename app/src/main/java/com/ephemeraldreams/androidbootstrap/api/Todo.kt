package com.ephemeraldreams.androidbootstrap.api

data class Todo(
    val id: Int = 0,
    val title: String = "",
    val completed: Boolean = false,
    val userId: Int
)
