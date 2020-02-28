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
        const val ActivityKotlin = "androidx.activity:activity-ktx:$version"
        const val AppCompat = "androidx.appcompat:appcompat:$version"
        const val CoreKotlin = "androidx.core:core-ktx:1.2.0"
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
