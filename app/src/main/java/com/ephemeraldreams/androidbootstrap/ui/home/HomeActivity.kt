package com.ephemeraldreams.androidbootstrap.ui.home

import android.os.Bundle
import android.widget.TextView
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject @ApplicationId lateinit var applicationId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textView = findViewById<TextView>(R.id.home_text_view)
        textView.text = applicationId
    }
}
