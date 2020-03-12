package com.ephemeraldreams.androidbootstrap.ui.home

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.ui.settings.SettingsActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule var homeActivityRule = IntentsTestRule(HomeActivity::class.java)

    @Test
    fun initializeHomeActivity() {
        val packageName = ApplicationProvider.getApplicationContext<Context>().packageName
        onView(withId(R.id.home_text_view))
            .check(matches(withText(packageName)))
        onView(withId(R.id.home_toolbar))
            .check(matches(isDisplayed()))
        onView(withText(R.string.app_name))
            .check(matches(withParent(withId(R.id.home_toolbar))))
    }

    @Test
    fun clickHomeFab() {
        onView(withId(R.id.home_fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Example action")))
    }

    @Test
    fun clickSettings() {
        openActionBarOverflowOrOptionsMenu(ApplicationProvider.getApplicationContext())
        onView(withText(R.string.action_settings_title))
            .perform(click())
        intended(hasComponent(SettingsActivity::class.java.name))
    }
}
