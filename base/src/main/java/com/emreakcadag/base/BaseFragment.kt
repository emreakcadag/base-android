package com.emreakcadag.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding
        viewModel.onInit()
    }
}