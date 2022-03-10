package com.emreakcadag.base.extension

import android.view.View
import androidx.databinding.BindingAdapter
import com.emreakcadag.base.Constant

/**
 * Created by Emre Akçadağ on 10.03.2022
 */

@BindingAdapter("app:visibility")
fun View?.visibility(value: Any?) = this?.run {
    value?.let {
        visibility = when (value) {
            View.VISIBLE, View.GONE, View.INVISIBLE -> it as Int
            (it is String && it == Constant.BLANK) -> View.GONE
            (it is Boolean && !it) -> View.GONE
            (it is List<*> && it.isNullOrEmpty()) -> View.GONE
            else -> View.VISIBLE
        }
    }
}