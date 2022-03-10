package com.emreakcadag.baseandroid.main.ui

import androidx.activity.viewModels
import com.emreakcadag.base.BaseActivity
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override val viewModel: MainViewModel by viewModels()
}