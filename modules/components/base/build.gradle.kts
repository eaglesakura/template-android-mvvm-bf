apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    /**
     * Kotlin support
     */
    "implementation"(project(":commons-resources"))
    "implementation"(project(":models-components"))
    "implementation"(project(":factories"))

    "implementation"("com.eaglesakura.armyknife.armyknife-jetpack:armyknife-jetpack:1.3.14")
    "implementation"("com.eaglesakura.armyknife.armyknife-reactivex:armyknife-reactivex:1.3.0")
    "implementation"("com.eaglesakura.firearm.firearm-experimental:firearm-experimental:1.3.5")
    "implementation"("com.eaglesakura.firearm.firearm-workflow:firearm-workflow:0.1.1")
    "implementation"("com.eaglesakura.firearm.firearm-event:firearm-event:1.3.0")

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
