import com.ephemeraldreams.Dependencies
import com.ephemeraldreams.Git
import com.ephemeraldreams.Versions

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    jacoco
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
        buildConfigField("String", "GIT_REF", "\"${Git.ref()}\"")
        buildConfigField("String", "GIT_SHA", "\"${Git.sha()}\"")
    }
    buildTypes {
        getByName("debug") {
            applicationIdSuffix = ".debug"
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    lintOptions {
        isCheckDependencies = true
        isCheckGeneratedSources = true
    }
    testOptions {
        animationsDisabled = true
        unitTests.isIncludeAndroidResources = true
    }
    viewBinding {
        isEnabled = true
    }
}

tasks.withType<Test> {
    configure<JacocoTaskExtension> {
        isIncludeNoLocationClasses = true
    }
}
task<JacocoReport>("jacocoTestReport") {
    mustRunAfter("testDebugUnitTest", "createDebugAndroidTestCoverageReport")
    description = "Create JaCoCo test coverage report from data gathered from unit or " +
            "instrumentation tests."
    reports {
        html.isEnabled = true
        html.destination = file("${project.buildDir}/reports/jacoco/html")
    }
    val fileFilter = mutableSetOf(
        "android/**/*.*",
        "**/R.class",
        "**/R$*.class",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "**/*Binding.*",
        "**/*Test*.*",
        // Dagger generated classes
        "**/*_MembersInjector.*",
        "**/Dagger*Component*.*",
        "**/*Module_*Factory*.*"
    )
    val debugKotlinFileTree = fileTree("${project.buildDir}/tmp/kotlin-classes/debug") {
        exclude(fileFilter)
    }
    val debugJavaFileTree = fileTree("${project.buildDir}/intermediates/javac/debug") {
        exclude(fileFilter)
    }
    val mainKotlinSrcDir = "${project.projectDir}/src/main/kotlin"
    val mainJavaSrcDir = "${project.projectDir}/src/main/java"

    sourceDirectories.setFrom(files(mainKotlinSrcDir, mainJavaSrcDir))
    classDirectories.setFrom(files(debugKotlinFileTree, debugJavaFileTree))
    executionData.setFrom(fileTree(project.buildDir) {
        include(
            "jacoco/testDebugUnitTest.exec",
            "outputs/code_coverage/debugAndroidTest/connected/*coverage.ec"
        )
    })
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
    implementation(Dependencies.AndroidX.CommonJava8)
    implementation(Dependencies.AndroidX.ViewModelSavedState)

    // AndroidX Kotlin Extension libraries.
    implementation(Dependencies.AndroidX.KTX.Activity)
    implementation(Dependencies.AndroidX.KTX.Collection)
    implementation(Dependencies.AndroidX.KTX.Core)
    implementation(Dependencies.AndroidX.KTX.Fragment)
    implementation(Dependencies.AndroidX.KTX.LiveData)
    implementation(Dependencies.AndroidX.KTX.Preference)
    implementation(Dependencies.AndroidX.KTX.ViewModel)

    // AndroidX UI and layout libraries.
    implementation(Dependencies.AndroidX.UI.ConstraintLayout)
    implementation(Dependencies.AndroidX.UI.Material)
    implementation(Dependencies.AndroidX.UI.SwipeRefreshLayout)
    implementation(Dependencies.AndroidX.UI.ViewPager2)

    // AndroidX Paging library.
    implementation(Dependencies.AndroidX.Paging.RuntimeKtx)
    testImplementation(Dependencies.AndroidX.Paging.CommonKtx)

    // AndroidX Room persistence library.
    implementation(Dependencies.AndroidX.Room.Runtime)
    implementation(Dependencies.AndroidX.Room.KTX)
    kapt(Dependencies.AndroidX.Room.Compiler)
    androidTestImplementation(Dependencies.AndroidX.Room.Test)

    // AndroidX WorkManager library.
    implementation(Dependencies.AndroidX.Work.RuntimeKtx)
    androidTestImplementation(Dependencies.AndroidX.Work.Test)

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
    implementation(platform(Dependencies.Square.OkHttp.Bom))
    implementation(Dependencies.Square.OkHttp.OkHttp)
    implementation(Dependencies.Square.OkHttp.LoggingInterceptor)
    testImplementation(Dependencies.Square.OkHttp.MockWebServer)

    // Retrofit REST API client library.
    implementation(Dependencies.Square.Retrofit.Retrofit)
    implementation(Dependencies.Square.Retrofit.ConverterMoshi)

    // Timber logging library.
    implementation(Dependencies.Timber)

    // LeakCanary memory leak detection library
    debugImplementation(Dependencies.Square.LeakCanary)

    // Testing libraries.
    testImplementation(Dependencies.Junit)
    testImplementation(Dependencies.Google.Truth)
    androidTestImplementation(Dependencies.Google.Truth)

    // AndroidX testing libraries.
    androidTestImplementation(Dependencies.AndroidX.Test.Junit)
    androidTestImplementation(Dependencies.AndroidX.Test.Rules)
    androidTestImplementation(Dependencies.AndroidX.Test.Runner)
    androidTestImplementation(Dependencies.AndroidX.Test.Truth)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Accessibility)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Contrib)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Core)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Idling)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Intents)
    androidTestImplementation(Dependencies.AndroidX.Test.Espresso.Web)
}
