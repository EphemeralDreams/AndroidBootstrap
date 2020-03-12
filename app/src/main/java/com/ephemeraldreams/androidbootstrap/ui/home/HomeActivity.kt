package com.ephemeraldreams.androidbootstrap.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.annotations.ApplicationId
import com.ephemeraldreams.androidbootstrap.databinding.ActivityHomeBinding
import com.ephemeraldreams.androidbootstrap.ui.settings.SettingsActivity
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
        setSupportActionBar(homeBinding.homeToolbar)

        homeBinding.homeTextView.text = applicationId
        homeBinding.homeFab.setOnClickListener { view ->
            Snackbar.make(view, "Example action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
            true
        } else -> {
            super.onOptionsItemSelected(item)
        }
    }
}
