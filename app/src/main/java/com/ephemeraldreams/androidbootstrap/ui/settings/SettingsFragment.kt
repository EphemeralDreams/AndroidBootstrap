package com.ephemeraldreams.androidbootstrap.ui.settings

import android.os.Bundle
import com.ephemeraldreams.androidbootstrap.BuildConfig
import com.ephemeraldreams.androidbootstrap.R

open class SettingsFragment : DaggerPreferenceFragment() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.global_preferences, rootKey)
        setPreferenceSummary(R.string.pref_version_key, BuildConfig.VERSION_NAME)
    }
}
