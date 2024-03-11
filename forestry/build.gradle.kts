plugins {
    id("jvm.roots.kotlin-application-conventions")
    java
}

dependencies {
    implementation(project(":branches"))
}

application {
    // Define the main class for the application.
    val mainClassName = when (properties["main"]) {
        "kotlin" -> "AppKt"
        "java" -> "JavaApp"
        else -> "AppKt"
    }
    mainClass.set("jvm.roots.forestry.$mainClassName")
}
