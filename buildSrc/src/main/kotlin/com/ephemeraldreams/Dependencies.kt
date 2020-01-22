package com.ephemeraldreams

import java.util.Locale

object Versions {
    const val buildTools = "29.0.2"
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29

    const val googleJavaFormat = "1.7"
    const val klint = "0.36.0"

    /**
     * Check whether [version] is not a stable version.
     */
    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any {
            version.toUpperCase(Locale.ROOT).contains(it)
        }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
}

object Dependencies {

    object AndroidX {
        private const val version = "1.1.0"
        const val ActivityKotlin = "androidx.activity:activity-ktx:1.0.0"
        const val AppCompat = "androidx.appcompat:appcompat:$version"
        const val CoreKotlin = "androidx.core:core-ktx:$version"
        const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"

        object Test {
            const val Junit = "androidx.test.ext:junit:1.1.1"

            object Espresso {
                private const val version = "3.2.0"
                const val Core = "androidx.test.espresso:espresso-core:$version"
            }
        }
    }

    object Google {
        object Dagger {
            private const val version = "2.25.4"
            const val Dagger = "com.google.dagger:dagger:$version"
            const val Compiler = "com.google.dagger:dagger-compiler:$version"
            const val AndroidSupport = "com.google.dagger:dagger-android-support:$version"
            const val AndroidProcessor = "com.google.dagger:dagger-android-processor:$version"
        }
    }

    const val Junit = "junit:junit:4.12"

    object Kotlin {
        const val StdlibJDK8 = "stdlib-jdk8"
        const val Test = "test"
        const val TestJunit = "test-junit"

        object Coroutines {
            private const val version = "1.3.3"
            const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val Test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Square {
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.1"

        object OkHttp {
            private const val version = "4.3.1"
            const val OkHttp = "com.squareup.okhttp3:okhttp:$version"
            const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
            const val MockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
        }
    }

    const val Timber = "com.jakewharton.timber:timber:4.7.1"
}
