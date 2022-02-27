package com.emreakcadag.baseandroid

import android.os.Bundle
import com.emreakcadag.baseandroid.databinding.ActivityMainBinding
import com.example.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    override val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}