apply(from = rootProject.file("dsl/environments.gradle.kts"))
apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    "implementation"(project(":factories:factories"))
    "implementation"(project(":views:base"))
    "implementation"("com.eaglesakura:army-knife:${extras.dependencies.armyKnifeVersion}")
}
