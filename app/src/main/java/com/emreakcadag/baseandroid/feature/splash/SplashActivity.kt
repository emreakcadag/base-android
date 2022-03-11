package com.emreakcadag.baseandroid.feature.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.emreakcadag.base.BaseActivity
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.databinding.ActivitySplashBinding
import com.emreakcadag.baseandroid.feature.main.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity() {

    override val binding by viewBinding(ActivitySplashBinding::inflate)

    override val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.navigateMainActivityLiveData.observe(this) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}