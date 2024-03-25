@file:Suppress("UnstableApiUsage")

import tests.JvmRootsTestListener

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            targets.all{
                testTask.configure {
                    useJUnitPlatform()
                    outputs.upToDateWhen { false }
                    addTestListener(JvmRootsTestListener())

                    testLogging {
                        showStandardStreams = true
                    }
                }
            }
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}
