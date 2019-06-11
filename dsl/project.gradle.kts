import org.apache.tools.ant.taskdefs.condition.Os
import org.yaml.snakeyaml.Yaml

buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("org.yaml:snakeyaml:1.17")
    }
}

val isWindows: Boolean = Os.isFamily(Os.FAMILY_WINDOWS)
val gcloudExt = when {
    isWindows -> ".cmd"
    else -> ""
}

fun pullSecrets(configurePath: String) {
    @Suppress("UNCHECKED_CAST")
    (Yaml().load(file(configurePath).readText()) as Map<Any, Any>).also { yaml ->
        println("install secrets")
        (yaml["secrets"] as Map<Any, Any>).also { configs ->
            val from = configs["from"].toString()
            val to = configs["to"].toString()
            exec {
                executable = "gsutil$gcloudExt"
                args = listOf(
                    "cp", "-R", "$from/*", to
                )
            }.rethrowFailure()
        }
    }
}

fun copySecrets(configurePath: String) {
    @Suppress("UNCHECKED_CAST")
    (Yaml().load(file(configurePath).readText()) as Map<Any, Any>).also { yaml ->
        println("copy files")
        (yaml["copy"] as List<Map<Any, Any>>).forEach { configs ->
            val from = configs["from"].toString()
            val to = configs["to"].toString()
            val overwrite = configs["overwrite"] as? Boolean ?: false
            if (overwrite || !file(to).exists()) {
                file(from).copyTo(
                    target = file(to),
                    overwrite = overwrite
                )
            }
            println("  '$from' to '$to' # overwrite='$overwrite'")
        }
    }
}

/**
 * setup this project.
 * You should call this task after clone this repository.
 *
 * e.g.)
 * gcloud init # authorize your account
 *  ./gradlew projectSetup
 */
task("projectSetup") {
    group = "project"
    description = "setup ${rootProject.name}"
    doLast {
        pullSecrets(".configs/secrets/configure.yaml")
        copySecrets(".configs/secrets/configure.yaml")
    }
}

/**
 * setup this project.
 * You should call this task after clone this repository.
 *
 * e.g.)
 * gcloud init # authorize your account
 *  ./gradlew projectSetup
 */
task("projectInstallSecrets") {
    group = "project"
    description = "install secret files"
    doLast {
        copySecrets(".configs/secrets/configure.yaml")
    }
}

/**
 * Clean Intellij Idea's project files and caches.
 * e.g.)
 *  ./gradlew ideaClean
 */
task("ideaClean") {
    group = "project"
    description = "clean up Intellij(Android Studio) files."
    doLast {
        val deletes = mutableListOf<File>()

        fileTree(".").forEach { file ->
            if (file.isFile && file.name.endsWith(".iml")) {
                deletes.add(file)
            }
        }

        file(".idea").deleteRecursively()
        deletes.forEach { file ->
            println("rm $file")
            file.delete()
        }
    }
}