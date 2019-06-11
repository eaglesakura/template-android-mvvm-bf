val extras = Extras(this)

/**
 * TODO: Set your application version.
 * Application version name(base).
 *
 * e.g.)
 * versionName = "0.1.{build-number}.{flavor-name}"
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["app_version_name"] = let {
    val applicationVersion = "0.1"

    return@let when {
        extras.build.ci -> "$applicationVersion.${extras.build.ci}"
        extras.buildByAndroidStudio -> "$applicationVersion.studio"
        else -> "$applicationVersion.local"
    }
}

/**
 * TODO: Set your application id.
 * Application ID for app.apk
 * this id will use to url in Google Play.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["app_application_id_base"] = "com.eaglesakura.mvvm_bf_template"

apply(from = rootProject.file("dsl/android-app.gradle"))

println("app_version_name            : ${extra["app_version_name"]}")
println("android_studio              : ${extras.buildByAndroidStudio}")
println("android_build_date          : ${extras.build.date}")
println("android_assemble_dpi        : ${extras.androidApp.assembleDpi}")

dependencies {
    /**
     * Kotlin support
     */
    "implementation"(project(":models-domain"))
    "implementation"(project(":components-base"))
    "implementation"(project(":components-splash"))
    "implementation"("com.eaglesakura.armyknife.armyknife-timber:armyknife-timber:1.3.0")
}
