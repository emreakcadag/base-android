package com.emreakcadag.base.extension

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.emreakcadag.common.Constant.BLANK

/**
 * Created by Emre Akçadağ on 10.03.2022
 */

@BindingAdapter("app:visibility")
fun View?.visibility(value: Any?) = this?.run {
    value?.let {
        visibility = when (value) {
            View.VISIBLE, View.GONE, View.INVISIBLE -> it as Int
            (it is String && it == BLANK) -> View.GONE
            (it is Boolean && !it) -> View.GONE
            (it is List<*> && it.isNullOrEmpty()) -> View.GONE
            else -> View.VISIBLE
        }
    }
}

@BindingAdapter("app:setImageUrl")
fun ImageView?.setImageUrl(imageUrl: String?) = this?.run {
    Glide.with(this)
        .load(imageUrl)
        .dontAnimate()
        .circleCrop()
        .into(this)
}