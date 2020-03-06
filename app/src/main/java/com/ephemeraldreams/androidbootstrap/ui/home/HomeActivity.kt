package com.ephemeraldreams.androidbootstrap.ui.home

import android.os.Bundle
import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import com.ephemeraldreams.androidbootstrap.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject @ApplicationId lateinit var applicationId: String
    private lateinit var homeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        homeBinding.homeTextView.text = applicationId
        homeBinding.homeFab.setOnClickListener { view ->
            Snackbar.make(view, "Example action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
