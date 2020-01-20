import com.ephemeraldreams.Versions
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// FIXME: The dependencies defined in both buildscript{} and plugins{} blocks are hard-coded since
//  we cannot import dependencies or versions from buildSrc due to a bug in Kotlin DSL. More details
//  can be found at https://github.com/gradle/gradle/issues/9270
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath(kotlin("gradle-plugin", "1.3.61"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
plugins {
    id("com.diffplug.gradle.spotless") version "3.27.1"
    id("com.github.ben-manes.versions") version "0.27.0"
}
allprojects {
    repositories {
        google()
        jcenter()
    }
}
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf { isNonStable(candidate.version) }
}
spotless {
    java {
        target("**/*.java")
        googleJavaFormat(Versions.googleJavaFormat)
    }
    kotlin {
        target("**/*.kt")
        ktlint(Versions.klint)
    }
}
