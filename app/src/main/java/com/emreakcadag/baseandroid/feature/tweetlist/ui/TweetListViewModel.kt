package com.emreakcadag.baseandroid.feature.tweetlist.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.SingleLiveData
import com.emreakcadag.baseandroid.feature.tweetlist.ui.list.TweetListAdapter
import com.emreakcadag.data.entity.tweetlist.TweetListViewEntity
import com.emreakcadag.data.entity.tweetlist.TweetListViewEntity.Companion.fromResponse
import com.emreakcadag.data.entity.tweetlist.TweetViewEntity
import com.emreakcadag.domain.usecase.tweetlist.GetTweetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.internal.toImmutableList
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class TweetListViewModel @Inject constructor(
    private val getTweetListUseCase: GetTweetListUseCase,
) : BaseViewModel() {

    val tweetListAdapterObservable = ObservableField<TweetListAdapter?>()

    private val tweetListAdapter = TweetListAdapter {
        _onItemClickLiveData.value = it
    }.also {
        tweetListAdapterObservable.set(it)
    }

    private var nextToken: String? = null
    private val tweetList: ArrayList<TweetViewEntity> = arrayListOf()

    private val _onItemClickLiveData = SingleLiveData<TweetViewEntity>()
    val onItemClickLiveData: LiveData<TweetViewEntity> = _onItemClickLiveData

    override fun onInit() {
        getTweetListData()
    }

    fun getTweetListData() {
        getTweetListUseCase.execute(
            GetTweetListUseCase.Params(
                "elonmusk",
                nextToken,
            )
        ).withProgressBar().onSuccess {
            it.fromResponse()?.let { viewEntity ->
                setTweetListAdapter(viewEntity)
                nextToken = viewEntity.nextToken
            }
        }.subscribe()
    }

    private fun setTweetListAdapter(tweetListViewEntity: TweetListViewEntity?) {
        tweetListViewEntity?.tweetList?.let { tweetList.addAll(it) }
        tweetListAdapter.submitList(tweetList.toImmutableList())
    }
}