import java.nio.charset.Charset

/**
 * configuration for army-knife module.
 *
 * @author @eaglesakura
 * @link https://github.com/eaglesakura/template-android-mvvm-bf
 * @link https://github.com/eaglesakura/army-knife
 */
repositories {
    maven(url = "https://dl.bintray.com/eaglesakura/maven/")
}
extra["army_knife_version"] = if (hasProperty("overwrite_army_knife_version")) {
    "${properties["overwrite_army_knife_version"]}"
} else {
    "1.1.9"
}

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
if (rootProject.file("private/configs.gradle.kts").isFile) {
    apply(from = rootProject.file("private/configs.gradle.kts"))
}
