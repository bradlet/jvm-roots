package tests

import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

class JvmRootsTestListener: TestListener {
    override fun beforeSuite(suite: TestDescriptor?) {
        if (suite?.parent === null) {
            println(suite?.displayName)
        }
    }

    override fun afterSuite(suite: TestDescriptor?, result: TestResult?) {
        if (suite?.parent === null) {
            result?.let { tests ->
                println("Succeeded ${tests.successfulTestCount} | Failed  ${tests.failedTestCount} | Skipped ${tests.skippedTestCount}")
            }
        }
    }

    override fun beforeTest(testDescriptor: TestDescriptor?) {
        print("Running test ${testDescriptor?.className}.${testDescriptor?.name}...")
    }

    override fun afterTest(testDescriptor: TestDescriptor?, result: TestResult?) {
        println(result?.resultType)
    }
}