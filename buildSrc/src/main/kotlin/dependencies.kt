object Versions {
    const val buildTools = "29.0.3"
    const val compileSdk = 29
    const val minSdk = 23
    const val targetSdk = 29

    const val googleJavaFormat = "1.7"
    const val klint = "0.36.0"

    /**
     * Check whether [version] is not a stable version.
     */
    fun isNonStable(version: String): Boolean {
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = regex.matches(version)
        return isStable.not()
    }
}

object Dependencies {

    object AndroidX {
        const val AppCompat = "androidx.appcompat:appcompat:1.2.0"
        const val Activity = "androidx.activity:activity-ktx:1.1.0"
        const val Collection = "androidx.collection:collection-ktx:1.1.0"
        const val Core = "androidx.core:core-ktx:1.3.2"
        const val Preference = "androidx.preference:preference-ktx:1.1.1"

        object Fragment {
            private const val version = "1.2.5"
            const val Ktx = "androidx.fragment:fragment-ktx:$version"
            const val Testing = "androidx.fragment:fragment-testing:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0"
            const val CommonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
            const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val ViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
        }

        object Navigation {
            private const val version = "2.3.2"
            const val FragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
            const val UiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        }

        object Paging {
            private const val version = "2.1.2"
            const val RuntimeKtx = "androidx.paging:paging-runtime-ktx:$version"
            const val CommonKtx = "androidx.paging:paging-common-ktx:$version"
        }

        object Room {
            private const val version = "2.2.5"
            const val Runtime = "androidx.room:room-runtime:$version"
            const val KTX = "androidx.room:room-ktx:$version"
            const val Compiler = "androidx.room:room-compiler:$version"
            const val Test = "androidx.room:room-testing:$version"
        }

        object UI {
            const val ConstraintLayout = "androidx.constraintlayout:constraintlayout:2.0.4"
            const val Material = "com.google.android.material:material:1.2.1"
            const val SwipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"
            const val ViewPager2 = "androidx.viewpager2:viewpager2:1.0.0"
        }

        object Work {
            private const val version = "2.4.0"
            const val RuntimeKtx = "androidx.work:work-runtime-ktx:$version"
            const val Test = "androidx.work:work-testing:$version"
        }

        object Test {
            const val Junit = "androidx.test.ext:junit:1.1.2"
            const val Rules = "androidx.test:rules:1.3.0"
            const val Runner = "androidx.test:runner:1.3.0"
            const val Truth = "androidx.test.ext:truth:1.3.0"

            object Espresso {
                private const val version = "3.3.0"
                const val Accessibility = "androidx.test.espresso:espresso-accessibility:$version"
                const val Contrib = "androidx.test.espresso:espresso-contrib:$version"
                const val Core = "androidx.test.espresso:espresso-core:$version"
                const val Idling = "androidx.test.espresso.idling:idling-concurrent:$version"
                const val Intents = "androidx.test.espresso:espresso-intents:$version"
                const val Web = "androidx.test.espresso:espresso-web:$version"
            }
        }
    }

    object Google {
        object Dagger {
            private const val version = "2.30.1"
            const val Dagger = "com.google.dagger:dagger:$version"
            const val Compiler = "com.google.dagger:dagger-compiler:$version"
            const val AndroidSupport = "com.google.dagger:dagger-android-support:$version"
            const val AndroidProcessor = "com.google.dagger:dagger-android-processor:$version"
        }

        const val Truth = "com.google.truth:truth:1.1"
    }

    const val Junit = "junit:junit:4.13.1"

    object Kotlin {
        const val StdlibJDK8 = "stdlib-jdk8"
        const val Test = "test"
        const val TestJunit = "test-junit"

        object Coroutines {
            private const val version = "1.4.2"
            const val Core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val Android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val Test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Square {
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:2.5"

        object AssistedInject {
            private const val version = "0.6.0"
            const val Annotations = "com.squareup.inject:assisted-inject-annotations-dagger2:$version"
            const val Processor = "com.squareup.inject:assisted-inject-processor-dagger2:$version"
        }

        object Moshi {
            private const val version = "1.11.0"
            const val Moshi = "com.squareup.moshi:moshi:$version"
            const val MoshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
            const val MoshiKotlinCodegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        }

        object OkHttp {
            private const val version = "4.9.0"
            const val Bom = "com.squareup.okhttp3:okhttp-bom:$version"
            const val OkHttp = "com.squareup.okhttp3:okhttp"
            const val LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
            const val MockWebServer = "com.squareup.okhttp3:mockwebserver"
        }

        object Retrofit {
            private const val version = "2.9.0"
            const val Retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val ConverterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
        }
    }

    const val Timber = "com.jakewharton.timber:timber:4.7.1"
}
