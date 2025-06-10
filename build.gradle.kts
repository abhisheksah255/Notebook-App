plugins {

    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.serialization.plugin) apply false
    id("org.jetbrains.kotlin.android")
    id("jacoco") // ✅ Add JaCoCo plugin here
}

jacoco {
    toolVersion = "0.8.10"
}

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest")

    reports {
        xml.required.set(true)
        html.required.set(true)
    }

    classDirectories.setFrom(
        fileTree("${buildDir}/intermediates/javac/debug/classes") {
            exclude("**/R.class", "**/R$*.class", "**/BuildConfig.*", "**/Manifest*.*")
        }
    )

    sourceDirectories.setFrom(files("src/main/java", "src/main/kotlin"))
    executionData.setFrom(fileTree(buildDir).include("**/jacoco/testDebugUnitTest.exec"))
}
