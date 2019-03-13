package internal.micromodules.domain.core

import android.app.Application
import android.util.Log
import com.eaglesakura.template.domain.modules.Configuration

/**
 * Configuration for this module.
 */
object Configure : Configuration {

    override fun init(application: Application) {
    }

    override var log: (tag: String, message: String) -> Unit = { tag, msg -> Log.d(tag, msg) }
}

/**
 * Write message to log(Logcat or such else).
 */
internal fun Any.console(message: String) {
    Configure.log(javaClass.simpleName, message)
}
