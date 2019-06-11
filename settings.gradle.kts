rootProject.buildFileName = "build.gradle.kts"

fun includesInDirectory(root: String) {
    file("modules/$root").listFiles()?.forEach { dir ->
        if (!dir.isDirectory) {
            return@forEach
        }

        val buildGradleKts = File(dir, "build.gradle.kts")
        if (!buildGradleKts.isFile) {
            return@forEach
        }

        val projectName = if (dir.name == root) {
            ":$root"
        } else {
            ":$root-${dir.name}"
        }
        println("include \"$projectName\"")
        include(projectName)
        project(projectName).projectDir = dir
    }
}

includesInDirectory("commons")
includesInDirectory("models")
includesInDirectory("factories")
includesInDirectory("components")
include(":app")
