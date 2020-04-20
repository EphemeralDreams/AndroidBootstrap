package report

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions")
}
tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf { Versions.isNonStable(candidate.version) }
    gradleReleaseChannel = "current"
}
