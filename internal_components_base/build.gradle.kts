apply(from = "../dsl/environments.gradle.kts")
apply(from = "../dsl/android-library.gradle")

val extras = Extras(this)

dependencies {
    /**
     * Kotlin support
     */
    "implementation"(project(":internal_domain_components"))
    "implementation"(project(":internal_domain_resources"))
    "implementation"(project(":internal_factories"))
    // Utils
    "api"("com.eaglesakura:light-saver:1.4.2") {
        because("Bundle save / restore")
        exclude(group = "com.google.code.gson")
    }
    "api"("com.eaglesakura:onactivityresult-invoke:1.3.1") {
        because("onActivityResult handler with Annotation.")
    }

    "implementation"("com.eaglesakura:kerberus:${extras.dependencies.armyKnifeVersion}")
    "implementation"("com.eaglesakura:army-knife:${extras.dependencies.armyKnifeVersion}")
    "implementation"("com.eaglesakura:army-knife-reactivex:${extras.dependencies.armyKnifeVersion}")
    "implementation"("com.eaglesakura:firearm:${extras.dependencies.armyKnifeVersion}")
    "implementation"("com.eaglesakura:firearm-channel:${extras.dependencies.armyKnifeVersion}")
    "implementation"("com.eaglesakura:firearm-event:${extras.dependencies.armyKnifeVersion}")

    /**
     * Support Libraries
     * https://developer.android.com/topic/libraries/architecture/adding-components
     * https://developer.android.com/topic/libraries/support-library/refactor
     * https://developer.android.com/kotlin/ktx
     */
    "api"("com.google.android.material:material:1.0.0")
    "api"("com.dmitrymalkovich.android:material-design-dimens:1.4") {
        because("Material design dimension(color, margin, or such else)")
    }
}
