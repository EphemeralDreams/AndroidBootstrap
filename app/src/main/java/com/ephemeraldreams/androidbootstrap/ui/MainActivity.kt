package com.ephemeraldreams.androidbootstrap.ui

import android.os.Bundle
import com.ephemeraldreams.androidbootstrap.R
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
