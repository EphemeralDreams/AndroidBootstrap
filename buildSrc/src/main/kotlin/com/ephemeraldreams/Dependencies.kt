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
        const val AppCompat = "androidx.appcompat:appcompat:1.1.0"
        const val CommonJava8 = "androidx.lifecycle:lifecycle-common-java8:2.2.0"
        const val ViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.2.0"

        object KTX {
            const val Activity = "androidx.activity:activity-ktx:1.1.0"
            const val Collection = "androidx.collection:collection-ktx:1.1.0"
            const val Core = "androidx.core:core-ktx:1.2.0"
            const val Fragment = "androidx.fragment:fragment-ktx:1.2.2"
            const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"
            const val Preference = "androidx.preference:preference-ktx:1.1.0"
            const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        }

        object Room {
            private const val version = "2.2.4"
            const val Runtime = "androidx.room:room-runtime:$version"
            const val KTX = "androidx.room:room-ktx:$version"
            const val Compiler = "androidx.room:room-compiler:$version"
            const val Test = "androidx.room:room-testing:$version"
        }

        object UI {
            const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
            const val Material = "com.google.android.material:material:1.1.0"
            const val ViewPager2 = "androidx.viewpager2:viewpager2:1.0.0"
        }

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
            private const val version = "2.26"
            const val Dagger = "com.google.dagger:dagger:$version"
            const val Compiler = "com.google.dagger:dagger-compiler:$version"
            const val AndroidSupport = "com.google.dagger:dagger-android-support:$version"
            const val AndroidProcessor = "com.google.dagger:dagger-android-processor:$version"
        }
    }

    const val Junit = "junit:junit:4.13"

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
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.2"

        object Moshi {
            private const val version = "1.9.2"
            const val Moshi = "com.squareup.moshi:moshi:$version"
            const val MoshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
            const val MoshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        }

        object OkHttp {
            private const val version = "4.4.0"
            const val Bom = "com.squareup.okhttp3:okhttp-bom:$version"
            const val OkHttp = "com.squareup.okhttp3:okhttp"
            const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
            const val MockWebServer = "com.squareup.okhttp3:mockwebserver"
        }

        object Retrofit {
            private const val version = "2.7.1"
            const val Retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val ConverterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
        }
    }

    const val Timber = "com.jakewharton.timber:timber:4.7.1"
}
