plugins {
    `kotlin-dsl`
}
repositories {
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:3.28.1")
    implementation("com.github.ben-manes:gradle-versions-plugin:0.28.0")
}
