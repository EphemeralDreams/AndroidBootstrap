package com.ephemeraldreams.androidbootstrap.ui.settings

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.ephemeraldreams.androidbootstrap.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Test
import org.junit.runner.RunWith

@SmallTest
@RunWith(AndroidJUnit4::class)
class SettingsFragmentTest {

    @Test
    fun testSettingsFragmentInitialization() {
        launchFragmentInContainer<SettingsFragment>()
        // No Espresso assertions for AndroidX PreferenceFragmentCompat yet.
        onView(withId(androidx.preference.R.id.recycler_view))
            .check(matches(isDisplayed()))
            // These preferences should have been added.
            .check(matches(allOf(
                hasDescendant(withText(R.string.pref_about_title)),
                hasDescendant(withText(R.string.pref_version_title)
            ))))
            // Debug preferences should not be added.
            .check(matches(not(allOf(
                hasDescendant(withText(R.string.pref_developer_settings_title)),
                hasDescendant(withText(R.string.pref_version_code_title))
            ))))
    }
}
