package com.emreakcadag.baseandroid.main.ui

import android.os.Bundle
import androidx.activity.viewModels
import com.emreakcadag.base.BaseActivity
import com.emreakcadag.baseandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}