package micromodules.app.main

import android.app.Application
import com.eaglesakura.armyknife.timber.ConsoleTree
import com.eaglesakura.armyknife.timber.StackTraceTree
import internal.micromodules.domain.core.Configure
import com.eaglesakura.template.domain.modules.Configuration
import kotlinx.coroutines.CancellationException
import timber.log.Timber

internal object ApplicationConfigure : Configuration.BaseConfiguration() {
    override val dependencies: List<Configuration> = listOf()

    override fun onInitialize(application: Application) {
        internal.micromodules.components.base.Configure.reportError = this::reportError
        // for debug flags
        if (BuildConfig.DEBUG) {
            Timber.plant(StackTraceTree(StackTraceTree.POP_STACK_DEFAULT + 3))
//            val fabric = Fabric.Builder(application)
//                .kits(Crashlytics())
//                .debuggable(true)
//                .build()
//            Fabric.with(fabric)
        } else {
            Timber.plant(ConsoleTree())
        }

        this.log = { _, msg -> Timber.d(msg) }

        console("bootstrap completed.")
    }

    /**
     * Error report to Crashlytics.
     */
    private fun reportError(err: Throwable) {
        if (err is CancellationException) {
            return
        }

//        Crashlytics.logException(err)
        err.printStackTrace()
    }
}

/**
 * Write message to log(Logcat or such else).
 */
internal fun Any.console(message: String) {
    Configure.log(javaClass.simpleName, message)
}