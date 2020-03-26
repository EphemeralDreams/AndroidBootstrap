package com.ephemeraldreams.androidbootstrap.ui.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ephemeraldreams.androidbootstrap.R
import com.ephemeraldreams.androidbootstrap.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField var mainActivityRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun initializeMainActivity() {
        onView(withId(R.id.homeTextView))
            .check(matches(withText("This is home Fragment")))
    }
}
