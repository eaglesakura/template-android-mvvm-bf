package com.eaglesakura.domain.components

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.ServiceInfo

/**
 * e.g.)
 *     <?xml version="1.0" encoding="utf-8"?>
 *     <manifest xmlns:android="http://schemas.android.com/apk/res/android">
 *         <application android:theme="@style/Theme.AppCompat.NoActionBar">
 *             <activity android:name="com.example.HogeActivity">
 *                 <meta-data
 *                      android:name="com.example.COMPONENT_KEY"
 *                      android:value="com.example.screen.HOGE_COMPONENT" />
 *             </activity>
 *         </application>
 *     </manifest>
 */
internal interface AndroidComponent<T> {
    /**
     * Screen Unique ID.
     */
    val id: String

    /**
     * System Component key(in Android Manifest.xml)
     */
    val componentKey: String

    /**
     * Find component info.
     *
     * @see android.content.pm.ServiceInfo
     * @see android.content.pm.ActivityInfo
     */
    fun setComponentInfo(info: T)
}

abstract class ActivityComponent : AndroidComponent<ActivityInfo> {
    protected lateinit var info: ActivityInfo
        private set

    override fun setComponentInfo(info: ActivityInfo) {
        this.info = info
    }

    open fun getIntent(context: Context): Intent {
        return Intent().also {
            it.component = ComponentName(context.packageName, info.name)
        }
    }
}

abstract class ServiceComponent : AndroidComponent<ServiceInfo> {
    protected lateinit var info: ServiceInfo
        private set

    override fun setComponentInfo(info: ServiceInfo) {
        this.info = info
    }

    open fun getIntent(context: Context): Intent {
        return Intent().also {
            it.component = ComponentName(context.packageName, info.name)
        }
    }
}