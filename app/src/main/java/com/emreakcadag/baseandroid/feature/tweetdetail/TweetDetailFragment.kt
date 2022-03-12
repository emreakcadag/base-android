package com.emreakcadag.baseandroid.feature.tweetdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentTweetDetailBinding
import com.emreakcadag.baseandroid.feature.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetDetailFragment : BaseFragment(R.layout.fragment_tweet_detail) {

    override val binding by viewBinding(FragmentTweetDetailBinding::bind)

    override val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}