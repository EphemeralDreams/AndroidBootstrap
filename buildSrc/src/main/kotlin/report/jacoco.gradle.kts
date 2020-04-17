package report

plugins {
    jacoco
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
    group = "Verification"
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
