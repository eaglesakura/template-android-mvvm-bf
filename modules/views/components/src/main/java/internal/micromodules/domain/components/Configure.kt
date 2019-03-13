package internal.micromodules.domain.components

import android.app.Application
import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.ServiceInfo
import com.eaglesakura.domain.components.AndroidComponent
import com.eaglesakura.template.domain.modules.Configuration

/**
 * Configuration for this module.
 */
object Configure : Configuration.BaseConfiguration() {
    private const val META_COMPONENT_KEY = "com.eaglesakura.modules.components.COMPONENT_KEY"
    private lateinit var packageInfo: PackageInfo

    override val dependencies: List<Configuration> = listOf(
        internal.micromodules.domain.core.Configure
    )

    override fun onInitialize(application: Application) {

        packageInfo = application.packageManager.getPackageInfo(
            application.packageName,
            PackageManager.GET_ACTIVITIES or PackageManager.GET_SERVICES or PackageManager.GET_META_DATA
        )

        val activityComponents = listOf<AndroidComponent<ActivityInfo>>(
        )

        val serviceComponents = listOf<AndroidComponent<ServiceInfo>>(
        )

        for (activityInfo in (packageInfo.activities ?: emptyArray())) {
            val component =
                activityComponents.find {
                    it.componentKey == activityInfo.metaData?.getString(
                        META_COMPONENT_KEY
                    )
                }
            if (component != null) {
                component.setComponentInfo(activityInfo)
            } else {
                console("Unknown component[${activityInfo.name}]")
            }
        }

        for (serviceInfo in (packageInfo.services ?: emptyArray())) {
            val component =
                serviceComponents.find {
                    it.componentKey == serviceInfo.metaData?.getString(
                        META_COMPONENT_KEY
                    )
                }
            if (component != null) {
                component.setComponentInfo(serviceInfo)
            } else {
                console("Unknown component[${serviceInfo.name}]")
            }
        }
    }
}

/**
 * Write message to log(Logcat or such else).
 */
internal fun Any.console(message: String) {
    Configure.log(javaClass.simpleName, message)
}
