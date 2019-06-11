apply(from = rootProject.file("dsl/environments.gradle.kts"))
apply(from = rootProject.file("dsl/android-library.gradle"))

val extras = Extras(this)

dependencies {
    "implementation"(project(":commons-dependencies"))

    /**
     * Kotlin support
     */
    "api"("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${extras.kotlin.version}")
    "api"("org.jetbrains.kotlin:kotlin-reflect:${extras.kotlin.version}")
    "api"("org.jetbrains.kotlinx:kotlinx-coroutines-core:${extras.kotlin.coroutinesVersion}")
    "api"("org.jetbrains.kotlinx:kotlinx-coroutines-android:${extras.kotlin.coroutinesVersion}")
}
