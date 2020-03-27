package com.ephemeraldreams.androidbootstrap.ui.settings

import android.os.Bundle
import com.ephemeraldreams.androidbootstrap.BuildConfig
import com.ephemeraldreams.androidbootstrap.R

class DebugSettingsFragment : SettingsFragment() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        super.onCreatePreferences(savedInstanceState, rootKey)
        setPreferenceSummary(R.string.pref_version_code_key, BuildConfig.VERSION_CODE.toString())
        setPreferenceSummary(R.string.pref_git_ref_key, BuildConfig.GIT_REF)
        setPreferenceSummary(R.string.pref_git_sha_key, BuildConfig.GIT_SHA)
        setPreferenceSummary(R.string.pref_build_type_key, BuildConfig.BUILD_TYPE)
    }
}
