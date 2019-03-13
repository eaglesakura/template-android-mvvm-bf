import java.util.*

buildscript {
    extra["kotlin_version"] = "1.3.21"
    extra["kotlin_coroutines_version"] = "1.1.1"
    repositories {
        mavenLocal()
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.2")
        classpath(kotlin("gradle-plugin", version = "${extra["kotlin_version"]}"))
        classpath("org.jetbrains.dokka:dokka-android-gradle-plugin:0.9.17") // kotlin-docs
        classpath("com.github.ben-manes:gradle-versions-plugin:0.21.0") // version checking plugin

        // deploy to bintray
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
        classpath("com.jfrog.bintray.gradle:gradle-bintray-plugin:1.8.4")
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        jcenter()
        mavenCentral()
    }
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
    delete(rootProject.file("artifacts"))
}

// Register extras.
extra["build_date"] = Date()

/**
 * Build on Android Studio flag.
 * If this value is true then, Faster build speed.
 *
 * You must add build-options "-PdevBuild -Dorg.gradle.caching=true" in Android Studio settings.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["android_studio"] = hasProperty("devBuild")

if (file("private/configs.gradle.kts").isFile) {
    apply(from = "private/configs.gradle.kts")
}
