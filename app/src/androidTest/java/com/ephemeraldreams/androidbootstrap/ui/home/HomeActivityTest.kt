package com.ephemeraldreams.androidbootstrap.ui.home

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.ephemeraldreams.androidbootstrap.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun initializeHomeActivity() {
        val packageName = ApplicationProvider.getApplicationContext<Context>().packageName
        onView(withId(R.id.home_text_view))
            .check(matches(withText(packageName)))
        onView(withId(R.id.title_app_bar_text_view))
            .check(matches(withText(R.string.app_name)))
    }

    @Test
    fun clickHomeFab() {
        onView(withId(R.id.home_fab)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText("Example action")))
    }
}
