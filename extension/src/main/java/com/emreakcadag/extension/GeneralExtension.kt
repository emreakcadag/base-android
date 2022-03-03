package com.emreakcadag.extension

import android.util.Log
import com.emreakcadag.libs.BuildConfig

/**
 * Created by Emre Akçadağ on 28.02.2022
 */

const val KEY_TRY_CATCH = "TRY_CATCH_"

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

/**
 * try - catch - finally block extension function.
 * @returns the given function in tryBlock or catchBlock or null.
 */
inline fun <reified C, reified T> C.tryCatch(
    tryBlock: () -> T?,
    noinline catchBlock: ((Exception) -> Any?)? = null,
    noinline finallyBlock: (() -> Unit)? = null
): T? = try {
    tryBlock()?.takeUnless { it is Unit }

} catch (e: Exception) {
    logDebug(e.message, "$KEY_TRY_CATCH${C::class.simpleName}", isError = true)
    catchBlock?.invoke(e)?.run {
        takeIf { it is T } as? T?
    }
} finally {
    finallyBlock?.let { it() }
}