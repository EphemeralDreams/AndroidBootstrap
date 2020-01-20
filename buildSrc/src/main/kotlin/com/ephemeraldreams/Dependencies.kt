package com.ephemeraldreams

object Versions {
    const val buildTools = "29.0.2"
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29

    const val googleJavaFormat = "1.7"
    const val klint = "0.36.0"
}

object Deps {

    object Android {
        const val Gradle = "com.android.tools.build:gradle:3.5.3"
    }

    object AndroidX {
        private const val version = "1.1.0"
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

    const val Junit = "junit:junit:4.12"

    object Kotlin {
        private const val version = "1.3.61"
        const val Stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val Reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val GradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val TestJunit = "org.jetbrains.kotlin:kotlin-test-junit:$version"

        object Coroutines {
            private const val version = "1.3.3"
            const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val Test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Square {
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.1"
    }

    const val Timber = "com.jakewharton.timber:timber:4.7.1"
}
