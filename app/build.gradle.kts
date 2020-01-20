import com.ephemeraldreams.Deps
import com.ephemeraldreams.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTools)
    defaultConfig {
        applicationId = "com.ephemeraldreams.androidbootstrap"
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "${rootProject.name}-${versionName}")
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin libraries.
    implementation(Deps.Kotlin.Stdlib)
    implementation(Deps.Kotlin.Reflect)
    implementation(Deps.Kotlin.Coroutines.Core)
    implementation(Deps.Kotlin.Coroutines.Android)
    testImplementation(Deps.Kotlin.TestJunit)
    testImplementation(Deps.Kotlin.Coroutines.Test)

    // AndroidX core libraries.
    implementation(Deps.AndroidX.AppCompat)
    implementation(Deps.AndroidX.CoreKotlin)

    // AndroidX layout libraries.
    implementation(Deps.AndroidX.ConstraintLayout)

    // Timber logging library.
    implementation(Deps.Timber)

    // LeakCanary memory leak detection library
    debugImplementation(Deps.Square.LeakCanary)

    // Testing libraries.
    testImplementation(Deps.Junit)

    // AndroidX testing libraries.
    androidTestImplementation(Deps.AndroidX.Test.Junit)
    androidTestImplementation(Deps.AndroidX.Test.Espresso.Core)
}
