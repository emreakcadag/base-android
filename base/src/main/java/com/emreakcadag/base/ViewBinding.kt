package com.emreakcadag.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
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
        get() = cached ?: createBinding()

    override
    fun isInitialized() = cached != null

    private fun createBinding(): VB {
        return binder?.invoke(layoutInflater, activityContainer, true)?.also {
            if (it is ViewDataBinding) {
                it.setVariable(BR.viewModel, viewModel)
                it.setLifecycleOwner { lifecycle.apply { addObserver(lifeCycleObserver) } }
            }

            cached = it
        }
            ?: throw IllegalStateException("You didn't set a valid layout for this activity, yet you try to access that :)")
    }

    private val lifeCycleObserver = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            cached = null
        }
    }
}

/**
 * Created by Emre Akçadağ on 10.03.2022
 *
 * @return binding object.
 *
 * if Fragment xml created between <layout> </layout> tags, binding object provides by ViewDataBinding
 * Otherwise, ViewBinding will be using.
 */
inline fun <reified VB : ViewBinding> BaseFragment.viewBinding(noinline binder: ((View) -> VB)? = null) = object : Lazy<VB> {
    private var cached: VB? = null

    override val value: VB
        get() = cached ?: createBinding()

    override
    fun isInitialized() = cached != null

    private fun createBinding(): VB = (binder?.invoke(requireView()))?.also {
        if (it is ViewDataBinding) {
            it.setVariable(BR.viewModel, viewModel)
            it.lifecycleOwner = viewLifecycleOwner.apply {
                lifecycle.addObserver(lifeCycleObserver)
            }
        }
        cached = it
    }
        ?: throw IllegalStateException("You didn't set a valid layout for this fragment, yet you try to access that :)")

    private val lifeCycleObserver = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            cached = null
        }
    }
}