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
 * Note: If you want to use ViewDataBinding then create Activity content between <Layout> </layout> tags.
 * Otherwise default choice will be ViewBinding.
 *
 * You can use [View Binding](https://developer.android.com/topic/libraries/view-binding) by supplying a binding inflater.
 * You can use [View Data Binding](https://developer.android.com/topic/libraries/data-binding) by supplying a binding inflater.
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
        rootBinding = BaseActivityBinding.inflate(layoutInflater).also {
            it.setVariable(BR.viewModel, viewModel)
            setContentView(it.root)
            activityContainer = it.activityContainer
        }

        // must be called to inflate the layout first.
        binding
    }

    override fun onStart() {
        super.onStart()

        viewModel.onInit()
    }

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    override fun onDestroy() {
        super.onDestroy()
        rootBinding.progressBar.visibility(false)
    }
}