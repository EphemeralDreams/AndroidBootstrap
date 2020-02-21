package com.ephemeraldreams.androidbootstrap.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ephemeraldreams.androidbootstrap.api.Todo
import com.ephemeraldreams.androidbootstrap.api.TodoRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    val repository: TodoRepository = TodoRepository()

    val firstTodo = liveData(Dispatchers.IO) {
        // val retrievedTodo = repository.getTodo(1)
        // emit(retrievedTodo)
        emit(Todo(userId = 1))
    }
}
