package com.emreakcadag.baseandroid.feature.tweetlist.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.emreakcadag.base.BaseFragment
import com.emreakcadag.base.extension.setOnPagingListener
import com.emreakcadag.base.viewBinding
import com.emreakcadag.baseandroid.R
import com.emreakcadag.baseandroid.databinding.FragmentTweetListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TweetListFragment : BaseFragment(R.layout.fragment_tweet_list) {

    override val binding by viewBinding(FragmentTweetListBinding::bind)

    override val viewModel: TweetListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvTweetList.setOnPagingListener { viewModel.getTweetListData() }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.onItemClickLiveData.observe(viewLifecycleOwner) {
            navigate(TweetListFragmentDirections.actionTweetListFragmentToTweetDetailFragment())
        }
    }
}