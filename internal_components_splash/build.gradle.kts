apply(from = "../dsl/environments.gradle.kts")
apply(from = "../dsl/android-library.gradle")

val extras = Extras(this)

dependencies {
    "implementation"(project(":internal_factories"))
    "implementation"(project(":internal_components_base"))
    "implementation"("com.eaglesakura:army-knife:${extras.dependencies.armyKnifeVersion}")
}
