apply(from = "../dsl/environments.gradle.kts")
apply(from = "../dsl/android-library.gradle")

val extras = Extras(this)

dependencies {
    /**
     * Kotlin support
     */
    "api"(project(":internal_domain"))
}
