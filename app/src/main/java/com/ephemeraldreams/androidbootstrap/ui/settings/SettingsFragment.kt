package com.ephemeraldreams.androidbootstrap.ui.settings

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.ephemeraldreams.androidbootstrap.BuildConfig
import com.ephemeraldreams.androidbootstrap.R

open class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.global_preferences, rootKey)
        setPreferenceSummary(R.string.pref_version_key, BuildConfig.VERSION_NAME)
    }

    /**
     * Set a summary for a given [Preference].
     *
     * @param id The resource string identifier for a preference key.
     * @param summary The summary string to set for the preference.
     */
    fun setPreferenceSummary(@StringRes id: Int, summary: String) {
        val preferenceKey = resources.getString(id)
        val preference: Preference? = findPreference(preferenceKey)
        preference?.summary = summary
    }
}
