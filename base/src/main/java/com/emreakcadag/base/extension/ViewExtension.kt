package com.emreakcadag.base.extension

import android.view.View
import android.view.View.*
import com.emreakcadag.base.Constant

/**
 * Created by Emre Akçadağ on 06.03.2022
 */

fun View?.visibility(value: Any?) {
    value?.let {
        this?.visibility = when (it) {
            VISIBLE, GONE, INVISIBLE -> it as Int
            (it is String && it == Constant.BLANK) -> GONE
            (it is Boolean && !it) -> GONE
            else -> VISIBLE
        }
    }
}