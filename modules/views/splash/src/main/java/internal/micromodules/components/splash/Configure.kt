package internal.micromodules.components.splash

import android.app.Application
import internal.micromodules.domain.core.Configure
import com.eaglesakura.template.domain.modules.Configuration

/**
 * Configuration for this module.
 */
object Configure : Configuration.BaseConfiguration() {
    override val dependencies: List<Configuration> = listOf(
        internal.micromodules.components.base.Configure
    )

    override fun onInitialize(application: Application) {
    }
}

/**
 * Write message to log(Logcat or such else).
 */
internal fun Any.console(message: String) {
    Configure.log(javaClass.simpleName, message)
}