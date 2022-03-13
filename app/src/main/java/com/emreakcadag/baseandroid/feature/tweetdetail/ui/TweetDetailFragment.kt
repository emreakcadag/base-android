package com.emreakcadag.baseandroid.feature.tweetdetail.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentTweetDetailBinding
import com.emreakcadag.data.entity.tweetdetail.TweetDetailViewEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetDetailFragment : BaseFragment(R.layout.fragment_tweet_detail) {

    override val binding by viewBinding(FragmentTweetDetailBinding::bind)

    override val viewModel: TweetDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<TweetDetailViewEntity>("tweetDetailViewEntity")?.let {
            viewModel.getTweetDetail(it)
        }
    }
}