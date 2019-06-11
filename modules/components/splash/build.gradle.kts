apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    "implementation"(project(":factories"))
    "implementation"(project(":components-base"))
    "implementation"("com.eaglesakura.armyknife.armyknife-jetpack:armyknife-jetpack:1.3.1")
}
