package com.emreakcadag.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.emreakcadag.base.extension.tryCatch

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
abstract class BaseFragment(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val binding: ViewBinding

    abstract val viewModel: BaseViewModel

    private var navigationController: NavController? = null

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding
        viewModel.onInit()
        navigationController = findNavController()
    }

    protected fun navigate(direction: NavDirections, navOptions: NavOptions? = null) {
        tryCatch({
            navigationController?.navigate(direction, navOptions = navOptions)
        })
    }
}