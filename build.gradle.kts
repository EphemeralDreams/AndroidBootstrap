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
        classpath("com.android.tools.build:gradle:3.6.2")
        classpath(kotlin("gradle-plugin", "1.3.72"))
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
plugins {
    id("code-style")
    id("report.dependency-updates")
}
allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}
