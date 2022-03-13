package com.emreakcadag.baseandroid.feature.tweetdetail.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentTweetDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetDetailFragment : BaseFragment(R.layout.fragment_tweet_detail) {

    override val binding by viewBinding(FragmentTweetDetailBinding::bind)

    override val viewModel: TweetDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            TweetDetailFragmentArgs.fromBundle(it).let { args ->
                viewModel.getTweetDetail(args.tweetDetailViewEntity)
            }
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.logoutLiveData.observe(viewLifecycleOwner) {
            navigate(TweetDetailFragmentDirections.actionTweetDetailFragmentToSplashFragment())
        }
    }
}