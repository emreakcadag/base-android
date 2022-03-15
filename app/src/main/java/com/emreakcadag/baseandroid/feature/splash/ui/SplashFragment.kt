package com.emreakcadag.baseandroid.feature.splash.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override val binding by viewBinding(FragmentSplashBinding::bind)

    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navigateOnStartUp(::navigate)
    }
}