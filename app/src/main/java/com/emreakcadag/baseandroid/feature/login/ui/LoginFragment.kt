package com.emreakcadag.baseandroid.feature.login.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment(R.layout.fragment_login) {

    override val binding by viewBinding(FragmentLoginBinding::bind)

    override val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.login(::navigate)
    }
}