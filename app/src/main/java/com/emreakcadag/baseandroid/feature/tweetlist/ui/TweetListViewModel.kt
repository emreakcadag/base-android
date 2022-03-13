package com.emreakcadag.baseandroid.feature.tweetlist.ui

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.data.entity.tweetlist.TweetListViewEntity.Companion.fromResponse
import com.emreakcadag.domain.usecase.tweetlist.GetTweetListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class TweetListViewModel @Inject constructor(
    private val getTweetListUseCase: GetTweetListUseCase,
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        getTweetListUseCase.execute(
            GetTweetListUseCase.Params(
                "from:elonmusk",
                null
            )
        ).withProgressBar()
            .onSuccess {
                val viewEntity = it.fromResponse()
            }.subscribe()
    }
}