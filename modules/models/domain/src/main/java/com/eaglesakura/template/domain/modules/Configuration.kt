package com.eaglesakura.template.domain.modules

import android.app.Application
import android.util.Log

interface Configuration {
    /**
     * Initialize module.
     */
    fun init(application: Application)

    /**
     * write log to log.
     */
    var log: (tag: String, message: String) -> Unit

    abstract class BaseConfiguration : Configuration {
        private var initialized: Boolean = false

        abstract val dependencies: List<Configuration>

        override fun init(application: Application) {
            if (!initialized) {
                synchronized(this) {
                    if (!initialized) {
                        for (configure in dependencies) {
                            configure.init(application)
                        }

                        onInitialize(application)
                        initialized = true
                    }
                }
            }
        }

        /**
         * oneshot initialize function.
         */
        protected abstract fun onInitialize(application: Application)

        override var log: (tag: String, message: String) -> Unit = { tag, message -> Log.d(tag, message) }
            set(value) {
                for (configure in dependencies) {
                    configure.log = value
                }
                field = value
            }
    }
}