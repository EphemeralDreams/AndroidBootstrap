package com.ephemeraldreams.androidbootstrap.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.api.JsonPlaceholderService
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var jsonPlaceholderService: JsonPlaceholderService
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("JsonService: %s", jsonPlaceholderService)

        model.firstTodo.observe(this, Observer {
            mainTextView.text = it.title
        })
    }
}
