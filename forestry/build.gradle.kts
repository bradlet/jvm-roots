plugins {
    id("jvm.roots.kotlin-application-conventions")
    java
}

dependencies {
    implementation(project(":branches"))
}

application {
    // Define the main class for the application.
    mainClass.set("jvm.roots.forestry.AppKt")
}
