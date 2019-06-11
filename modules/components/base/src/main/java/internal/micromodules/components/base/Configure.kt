package internal.micromodules.components.base

import android.app.Application
import internal.micromodules.domain.core.Configure
import com.eaglesakura.template.domain.modules.Configuration

/**
 * Configuration for this module.
 */
object Configure : Configuration.BaseConfiguration() {

    internal lateinit var application: Application
        private set

    override val dependencies: List<Configuration> = listOf()

    override fun onInitialize(application: Application) {
        internal.micromodules.components.base.Configure.application = application
    }

    /**
     * Error reporting.
     */
    var reportError: (err: Throwable) -> Unit = { err ->
        err.printStackTrace()
    }
}

/**
 * Write message to log(Logcat or such else).
 */
internal fun Any.console(message: String) {
    Configure.log(javaClass.simpleName, message)
}
