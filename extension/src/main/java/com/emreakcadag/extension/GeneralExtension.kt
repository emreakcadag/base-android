package com.example.extension

import android.util.Log
import com.emreakcadag.libs.BuildConfig

/**
 * Created by Emre Akçadağ on 28.02.2022
 */

inline val <reified T> T.TAG: String get() = T::class.java.name

/**
 * Log received message, works only debug mode
 */
inline fun <reified T> T.logDebug(message: Any?, logTag: String = "LogDebug: ${this.TAG}", isError: Boolean = false) {
    if (BuildConfig.DEBUG && message != null) {
        try {
            if (isError) Log.e(logTag, "$message") else Log.d(logTag, "$message")
        } catch (e: Exception) {
            Log.e(logTag, "${e.message}")
        }
    }
}