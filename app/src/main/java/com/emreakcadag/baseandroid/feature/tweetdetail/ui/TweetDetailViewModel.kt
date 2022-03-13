package com.emreakcadag.baseandroid.feature.tweetdetail.ui

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.domain.usecase.tweetdetail.GetTweetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 12.03.2022
 */
@HiltViewModel
class TweetDetailViewModel @Inject constructor(
    private val getTweetDetailUseCase: GetTweetDetailUseCase,
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        getTweetDetail()
    }

    private fun getTweetDetail() {
        getTweetDetailUseCase.execute("1503034939067047942")
            .withProgressBar()
            .onSuccess {

            }.subscribe()
    }
}