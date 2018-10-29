/**
 * Build on Android Studio flag.
 * If this value is true then, Faster build speed.
 *
 * You must add build-options "-PdevBuild -Dorg.gradle.caching=true" in Android Studio settings.
 */
ext.android_studio = rootProject.hasProperty("devBuild")

/**
 * Build target resource for debug build.
 */
ext.android_assemble_dpi = "xxhdpi"

if (android_studio) {
    ext.android_build_date = "\"date-devBuild\""
    ext.android_aapt_cruncher = false
} else {
    ext.android_build_date = "\"${new Date()}\""
    ext.android_aapt_cruncher = true
}

/**
 * Number of build.
 * This value is auto-increment on CircleCI.
 * When build on local(build on Developer's PC) then, this value is always 1.
 */
ext.build_number = {
    try {
        def BUILD_NUMBER_FILE = rootProject.file(".configs/secrets/build-number.env")
        if (BUILD_NUMBER_FILE.file) {
            return BUILD_NUMBER_FILE.text as int
        }
    } catch (ignored) {
    }

    if (System.env.CIRCLE_BUILD_NUM != null) {
        return System.env.CIRCLE_BUILD_NUM as int
    } else {
        return 1
    }
}()

/**
 * CircleCI flag.
 */
ext.build_on_ci = System.env.CIRCLE_BUILD_NUM != null

println "android_studio              : ${android_studio}"
println "android_build_date          : ${android_build_date}"
println "android_assemble_dpi        : ${android_assemble_dpi}"
println "android_aapt_cruncher       : ${android_aapt_cruncher}"
