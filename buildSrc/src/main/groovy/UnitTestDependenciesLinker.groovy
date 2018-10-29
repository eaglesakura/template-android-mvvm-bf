import org.gradle.api.Project

static void link(Project target) {
    target.dependencies {
        testImplementation 'org.robolectric:robolectric:4.0-beta-1'
        androidTestImplementation 'com.linkedin.dexmaker:dexmaker-mockito:2.19.1'
        androidTestImplementation 'androidx.multidex:multidex:2.0.0'
        androidTestImplementation 'androidx.multidex:multidex-instrumentation:2.0.0'
        androidTestImplementation('androidx.databinding:databinding-runtime:3.2.1') {
            because """
                for DataBinding in Library Project with UnitTest.
                Below libraries has alpha-versions.
            """
            exclude group: 'androidx.lifecycle'
            exclude group: 'androidx.arch.core'
            exclude group: 'androidx.collection'
        }
        kaptAndroidTest('com.android.databinding:compiler:3.2.1') {
            because "for DataBinding in Library Project with UnitTest."
        }
    }
}
