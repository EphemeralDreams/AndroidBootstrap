package com.ephemeraldreams.androidbootstrap.ui.settings

import android.os.Bundle
import com.ephemeraldreams.androidbootstrap.databinding.ActivitySettingsBinding
import dagger.android.support.DaggerAppCompatActivity

class SettingsActivity : DaggerAppCompatActivity() {

    private lateinit var settingsBinding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingsBinding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(settingsBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager
            .beginTransaction()
            .replace(settingsBinding.settingsContainer.id, SettingsFragment())
            .commit()
    }
}
