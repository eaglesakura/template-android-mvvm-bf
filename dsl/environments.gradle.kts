import java.nio.charset.Charset


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

/**
 * Build target resource for debug build.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["android_assemble_dpi"] = if (hasProperty("android_assemble_dpi")) {
    "${properties["android_assemble_dpi"]}"
} else {
    "xxhdpi"
}

extra["android_aapt_cruncher"] = try {
    extra["android_studio"] != null
} catch (e: Throwable) {
    false
}

/**
 * Number of build.
 * This value is auto-increment on CircleCI.
 * When build on local(build on Developer's PC) then, this value is always 1.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["build_number"] = let {
    val buildNumberFile = rootProject.file(".configs/secrets/build-number.env")
    if (buildNumberFile.isFile) {
        return@let buildNumberFile.readText(Charset.forName("UTF-8")).trim().toInt()
    }
    return@let System.getenv("CIRCLE_BUILD_NUM")?.toInt() ?: 1
}

/**
 * CircleCI(or such else) flag.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["build_on_ci"] = System.getenv("CIRCLE_BUILD_NUM") != null

/**
 * Max memory for assemble a dex file.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 */
extra["dex_max_heap_on_ci"] = System.getenv("MAX_DEX_HEAP_SIZE") ?: "2g"

/**
 * apply user configurations.
 */
arrayOf(
        rootProject.file("private/configs.gradle.kts"),
        rootProject.file("private/configs.gradle")
).forEach { file ->
    if (file.isFile) {
        apply(from = file)
    }
}
