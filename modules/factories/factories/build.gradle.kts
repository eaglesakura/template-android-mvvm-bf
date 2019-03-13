apply(from = rootProject.file("dsl/environments.gradle.kts"))
apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    /**
     * Kotlin support
     */
    "api"(project(":models:domain"))
}
