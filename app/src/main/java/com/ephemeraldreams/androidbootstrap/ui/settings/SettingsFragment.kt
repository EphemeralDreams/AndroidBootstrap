package com.ephemeraldreams.androidbootstrap.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.ephemeraldreams.androidbootstrap.R
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)

        val ossLicensesPreferenceKey = getString(R.string.preference_key_oss_licenses)
        val ossPreference: Preference? = findPreference(ossLicensesPreferenceKey)
        ossPreference?.intent = Intent(context, OssLicensesMenuActivity::class.java)
    }
}
