import java.util.*

buildscript {
    extra["kotlin_version"] = "1.3.41"
    extra["kotlin_coroutines_version"] = "1.2.2"
    extra["android_studio_version"] = "3.5.0-rc01"
    extra["build_date"] = java.util.Date()

    repositories {
        mavenLocal()
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${extra["android_studio_version"]}")
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
        maven(url = "https://dl.bintray.com/eaglesakura/maven/")
    }
}

subprojects {
    apply(from = rootProject.file("dsl/environments.gradle.kts"))
    apply(from = rootProject.file("dsl/ktlint.gradle"))
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}

apply(from = "dsl/project.gradle.kts")
