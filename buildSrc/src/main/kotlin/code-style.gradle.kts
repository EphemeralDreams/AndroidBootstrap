plugins {
    id("com.diffplug.gradle.spotless")
}
spotless {
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
