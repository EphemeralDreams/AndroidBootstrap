package com.ephemeraldreams.androidbootstrap.ui.settings

import android.content.Context
import androidx.annotation.StringRes
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class DaggerPreferenceFragment : PreferenceFragmentCompat(), HasAndroidInjector {

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
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
