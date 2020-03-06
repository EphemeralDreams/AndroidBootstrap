package com.ephemeraldreams.androidbootstrap

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ApplicationTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        var expectedPackageName = "com.ephemeraldreams.androidbootstrap"
        if (BuildConfig.DEBUG) {
            expectedPackageName += ".debug"
        }
        assertThat(expectedPackageName).isEqualTo(appContext.packageName)
    }
}
