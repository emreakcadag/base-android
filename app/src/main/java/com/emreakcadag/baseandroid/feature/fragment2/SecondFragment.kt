package com.emreakcadag.baseandroid.feature.fragment2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentSecondBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment(R.layout.fragment_second) {

    override val binding by viewBinding(FragmentSecondBinding::bind)

    override val viewModel: SecondViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navigationButton.setOnClickListener { navigate(R.id.action_secondFragment_to_firstFragment) }
    }
}