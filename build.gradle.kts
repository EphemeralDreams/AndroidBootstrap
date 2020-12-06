import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// FIXME: The dependencies defined in both buildscript{} and plugins{} blocks are hard-coded since
//  we cannot import dependencies or versions from buildSrc due to a bug in Kotlin DSL. More details
//  can be found at https://github.com/gradle/gradle/issues/9270
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.1")
        classpath(kotlin("gradle-plugin", "1.4.20"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
plugins {
    id("com.diffplug.spotless") version "5.8.2"
    id("com.github.ben-manes.versions") version "0.36.0"
}
allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf { Versions.isNonStable(candidate.version) }
    gradleReleaseChannel = "current"
}
spotless {
    format("misc") {
        target(
            // Data serialization files.
            "**/*.json",
            "**/*.yaml",
            "**/*.xml",
            // Plain text files.
            "**/*.md",
            "**/*.txt",
            // Configuration files.
            "**/.gitignore",
            "**/*.pro",
            "**/*.properties"
        )
        targetExclude("**/build/**", "**/.idea/**", "**/.gradle/**")
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
    java {
        target("**/*.java")
        targetExclude("**/build/**")
        googleJavaFormat(Versions.googleJavaFormat)
    }
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**")
        ktlint(Versions.klint)
    }
    kotlinGradle {
        target("**/*.kts")
        targetExclude("**/build/**")
        ktlint(Versions.klint)
    }
}
