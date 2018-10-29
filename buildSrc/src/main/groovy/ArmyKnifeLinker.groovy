import org.gradle.api.Project

static void apiToModule(Project target, String module) {
    final def version = "${target.properties["army_knife_version"]}"
    target.dependencies {
        try {
            api target.project(":$module")
        } catch (ignored) {
            api "com.eaglesakura:$module:$version"
        }
    }
}

static void implementationToModule(Project target, String module) {
    final def version = "${target.properties["army_knife_version"]}"
    target.dependencies {
        try {
            implementation target.project(":$module")
        } catch (ignored) {
            implementation "com.eaglesakura:$module:$version"
        }
    }
}

static void testImplementationToModule(Project target, String module) {
    final def version = "${target.properties["army_knife_version"]}"
    target.dependencies {
        try {
            testImplementation target.project(":$module")
        } catch (ignored) {
            testImplementation "$com.eaglesakura:$module:$version"
        }
    }
}

static void androidTestImplementationToModule(Project target, String module) {
    final def version = "${target.properties["army_knife_version"]}"
    target.dependencies {
        try {
            androidTestImplementation target.project(":$module")
        } catch (ignored) {
            androidTestImplementation "com.eaglesakura:$module:$version"
        }
    }
}

static void allTestImplementationToModule(Project target, String module) {
    final def version = "${target.properties["army_knife_version"]}"
    target.dependencies {
        try {
            testImplementation target.project(":$module")
            androidTestImplementation target.project(":$module")
        } catch (ignored) {
            testImplementation "com.eaglesakura:$module:$version"
            androidTestImplementation "com.eaglesakura:$module:$version"
        }
    }
}