package com.emreakcadag.baseandroid.feature.fragment1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstFragment : BaseFragment(R.layout.fragment_first) {

    override val binding by viewBinding(FragmentFirstBinding::bind)

    override val viewModel: FirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}