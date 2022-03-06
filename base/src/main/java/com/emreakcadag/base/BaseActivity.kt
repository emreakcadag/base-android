package com.emreakcadag.base

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.emreakcadag.base.databinding.BaseActivityBinding
import com.emreakcadag.base.extension.visibility

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

    lateinit var activityContainer: FrameLayout
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootBinding = BaseActivityBinding.inflate(layoutInflater)
        setContentView(rootBinding.root)
        activityContainer = rootBinding.activityContainer

        // must be called to inflate the layout first.
        binding
    }

    override fun onStart() {
        super.onStart()

        viewModel.onInit()
        viewModel.getProgressBarLiveData().observe(this, ::resetProgressBar)
    }

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    private fun resetProgressBar(loading: Boolean?) {
        rootBinding.progressBar.visibility(loading)
    }

    override fun onDestroy() {
        super.onDestroy()
        rootBinding.progressBar.visibility(false)
    }
}