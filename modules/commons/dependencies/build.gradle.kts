apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

/**
 * This module is dependency controller.
 */
dependencies {
    /**
     * Android Jetpack
     * https://developer.android.com/jetpack/androidx/versions
     */
    "api"("androidx.activity:activity:1.1.0-alpha01")
    "api"("androidx.activity:activity-ktx:1.1.0-alpha01")
    "api"("androidx.savedstate:savedstate:1.0.0-rc01")
    "api"("androidx.annotation:annotation:1.1.0")
    "api"("androidx.appcompat:appcompat:1.1.0-rc01")
    "api"("androidx.appcompat:appcompat-resources:1.1.0-rc01")
    "api"("androidx.arch.core:core-common:2.0.1")
    "api"("androidx.arch.core:core-runtime:2.0.1")
    "api"("androidx.core:core:1.0.2")
    "api"("androidx.core:core-ktx:1.0.2")
    "api"("androidx.fragment:fragment:1.0.0")
    "api"("androidx.fragment:fragment-ktx:1.0.0")
    "api"("androidx.lifecycle:lifecycle-extensions:2.0.0")
    "api"("androidx.lifecycle:lifecycle-viewmodel:2.0.0")
    "api"("androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-alpha02")
    "api"("androidx.lifecycle:lifecycle-viewmodel-ktx:2.0.0")
    "api"("androidx.lifecycle:lifecycle-runtime:2.0.0")
    "api"("androidx.lifecycle:lifecycle-common-java8:2.0.0")
    "api"("androidx.lifecycle:lifecycle-reactivestreams:2.0.0")
    "api"("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.0.0")
    "api"("androidx.collection:collection:1.1.0")
    "api"("androidx.collection:collection-ktx:1.1.0")
    "api"("androidx.versionedparcelable:versionedparcelable:1.1.0-rc01")

    "implementation"("androidx.vectordrawable:vectordrawable:1.0.1")
    "implementation"("androidx.constraintlayout:constraintlayout:2.0.0-beta2")

    /**
     * Army Knife
     */
    "implementation"("com.eaglesakura.armyknife.armyknife-runtime:armyknife-runtime:1.3.3")
    "implementation"("com.eaglesakura.armyknife.armyknife-jetpack:armyknife-jetpack:1.3.14")
    "implementation"("com.eaglesakura.armyknife.armyknife-jetpack-lifecycle:armyknife-jetpack-lifecycle:0.1.2")
    "implementation"("com.eaglesakura.firearm.firearm-experimental:firearm-experimental:1.3.5")
    "implementation"("com.eaglesakura.firearm.firearm-workflow:firearm-workflow:0.1.1")
}
