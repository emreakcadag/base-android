package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.base.databinding.BaseActivityBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by Emre Akçadağ on 27.02.2022
 *
 * You can use [View Binding](https://developer.android.com/topic/libraries/view-binding) by supplying a binding inflater.
 * Example:
 *
 * ```
 * @AndroidEntryPoint
 * class ExampleActivity : BaseActivity() {
 *     override val binding by viewBinding(ActivityExampleBinding::inflate)
 *     ...
 * }
 *
 * ```
 */
abstract class BaseActivity : AppCompatActivity() {

    private lateinit var rootBinding: BaseActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootBinding = BaseActivityBinding.inflate(layoutInflater)
        setContentView(rootBinding.root)

        // must be called to inflate the layout first.
        binding
    }

    abstract val binding: ViewBinding

    protected fun <VB : ViewBinding> viewBinding(binder: ((LayoutInflater, ViewGroup, Boolean) -> VB)? = null) = BindingProperty(binder)

    protected inner class BindingProperty<VB : ViewBinding>(private val binder: ((LayoutInflater, ViewGroup, Boolean) -> VB)? = null) : ReadOnlyProperty<BaseActivity, VB> {

        private var binding: VB? = null

        override fun getValue(thisRef: BaseActivity, property: KProperty<*>): VB {
            return binding ?: createBinding(thisRef)
        }

        private fun createBinding(activity: BaseActivity): VB {
            binding = binder?.invoke(activity.layoutInflater, activity.rootBinding.content, true)
                ?: throw IllegalStateException("You didn't set a layout for this activity, yet you try to access that :)")
            return binding as VB
        }
    }
}