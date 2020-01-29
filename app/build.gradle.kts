import com.ephemeraldreams.Dependencies
import com.ephemeraldreams.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
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
        setProperty("archivesBaseName", "${rootProject.name}-$versionName")
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
    implementation(kotlin(Dependencies.Kotlin.StdlibJDK8))
    testImplementation(kotlin(Dependencies.Kotlin.Test))
    testImplementation(kotlin(Dependencies.Kotlin.TestJunit))
    implementation(Dependencies.Kotlin.Coroutines.Core)
    implementation(Dependencies.Kotlin.Coroutines.Android)
    testImplementation(Dependencies.Kotlin.Coroutines.Test)

    // AndroidX core libraries.
    implementation(Dependencies.AndroidX.AppCompat)
    implementation(Dependencies.AndroidX.ActivityKotlin)
    implementation(Dependencies.AndroidX.CoreKotlin)
    implementation(Dependencies.AndroidX.Lifecycle.CommonJava8)
    implementation(Dependencies.AndroidX.Lifecycle.LiveDataKotlin)
    implementation(Dependencies.AndroidX.Lifecycle.ViewModelKotlin)
    implementation(Dependencies.AndroidX.Lifecycle.ViewModelSavedState)

    // AndroidX layout libraries.
    implementation(Dependencies.AndroidX.ConstraintLayout)

    // Dagger dependency injection library.
    implementation(Dependencies.Google.Dagger.Dagger)
    implementation(Dependencies.Google.Dagger.AndroidSupport)
    kapt(Dependencies.Google.Dagger.Compiler)
    kapt(Dependencies.Google.Dagger.AndroidProcessor)

    // Moshi JSON library.
    implementation(Dependencies.Square.Moshi.Moshi)
    implementation(Dependencies.Square.Moshi.MoshiKotlin)
    kapt(Dependencies.Square.Moshi.MoshiKotlinCodegen)

    // OkHttp networking library.
    implementation(Dependencies.Square.OkHttp.OkHttp)
    implementation(Dependencies.Square.OkHttp.LoggingInterceptor)
    implementation(Dependencies.Square.OkHttp.MockWebServer)

    // Retrofit REST API client library.
    implementation(Dependencies.Square.Retrofit.Retrofit)
    implementation(Dependencies.Square.Retrofit.ConverterMoshi)

    // Timber logging library.
    implementation(Dependencies.Timber)

    // LeakCanary memory leak detection library
    debugImplementation(Dependencies.Square.LeakCanary)

    // Testing libraries.
    testImplementation(Dependencies.Junit)

    // AndroidX testing libraries.
    androidTestImplementation(Dependencies.AndroidX.Test.Junit)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Core)
}
