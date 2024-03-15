package tests

import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

class JvmRootsTestListener: TestListener {
    override fun beforeSuite(suite: TestDescriptor?) {
        println("Running test suite: ${suite?.displayName}")
    }

    override fun afterSuite(suite: TestDescriptor?, result: TestResult?) {
        println("Completed test suite: ${suite?.displayName}")
        result?.let { tests ->
            println("Succeeded ${tests.successfulTestCount} / ${tests.testCount} (Skipped ${tests.skippedTestCount})")
        }
    }

    override fun beforeTest(testDescriptor: TestDescriptor?) {
        print("Running test ${testDescriptor?.displayName}...")
    }

    override fun afterTest(testDescriptor: TestDescriptor?, result: TestResult?) {
        println(result?.resultType)
    }
}