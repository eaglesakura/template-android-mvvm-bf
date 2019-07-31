apply(from = rootProject.file("dsl/environments.gradle.kts"))
apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    "implementation"(project(":commons-dependencies"))
}
