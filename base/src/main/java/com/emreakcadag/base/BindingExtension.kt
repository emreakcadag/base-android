package com.emreakcadag.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Emre Akçadağ on 03.03.2022
 */

fun <VB : ViewBinding> BaseActivity.viewBinding(binder: ((LayoutInflater, ViewGroup, Boolean) -> VB)? = null) = ViewBindingProperty(binder)

class ViewBindingProperty<VB : ViewBinding>(private val binder: ((LayoutInflater, ViewGroup, Boolean) -> VB)? = null) : ReadOnlyProperty<BaseActivity, VB> {

    private var binding: VB? = null

    override fun getValue(thisRef: BaseActivity, property: KProperty<*>): VB {
        return binding ?: createBinding(thisRef)
    }

    private fun createBinding(activity: BaseActivity): VB {
        binding = binder?.invoke(activity.layoutInflater, activity.container, true)
            ?: throw IllegalStateException("You didn't set a layout for this activity, yet you try to access that :)")
        return binding as VB
    }
}