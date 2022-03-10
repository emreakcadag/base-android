package com.emreakcadag.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding

/**
 * Created by Emre Akçadağ on 03.03.2022
 *
 * @return binding object.
 *
 * if Activity xml created between <layout> </layout> tags, binding object provides by ViewDataBinding
 * Otherwise, ViewBinding will be using.
 */
inline fun <reified VB : ViewBinding> BaseActivity.viewBinding(noinline binder: ((LayoutInflater, ViewGroup, Boolean) -> VB)? = null) = object : Lazy<VB> {
    private var cached: VB? = null

    override val value: VB
        get() = cached ?: createBinding(this@viewBinding)

    override
    fun isInitialized() = cached != null

    private fun createBinding(activity: BaseActivity): VB {
        cached = binder?.invoke(activity.layoutInflater, activity.activityContainer, true)?.also {
            if (it is ViewDataBinding) {
                it.setVariable(BR.viewModel, activity.viewModel)
                it.lifecycleOwner = activity
            }
        }
            ?: throw IllegalStateException("You didn't set a valid layout for this activity, yet you try to access that :)")

        return binding as VB
    }
}