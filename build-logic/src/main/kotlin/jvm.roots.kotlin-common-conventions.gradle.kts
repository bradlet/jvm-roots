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

//dependencies {
//    constraints {
//        // Define dependency versions as constraints
//        implementation("org.apache.commons:commons-text:1.10.0")
//    }
//}

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit Jupiter test framework
            useJUnitJupiter("5.10.0")

            targets.all{
                testTask.configure {
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
