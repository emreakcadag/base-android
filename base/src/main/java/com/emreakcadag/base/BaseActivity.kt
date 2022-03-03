package com.emreakcadag.base

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.emreakcadag.base.databinding.BaseActivityBinding

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

    lateinit var container: FrameLayout
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootBinding = BaseActivityBinding.inflate(layoutInflater)
        setContentView(rootBinding.root)
        container = rootBinding.content

        // must be called to inflate the layout first.
        binding

        viewModel.onInit()
        viewModel.getProgressBarLiveData().observe(this, ::resetProgressBar)
    }

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    private fun resetProgressBar(loading: Boolean?) {
        rootBinding.progressBar.visibility = if (loading == true) View.VISIBLE else View.GONE
    }
}