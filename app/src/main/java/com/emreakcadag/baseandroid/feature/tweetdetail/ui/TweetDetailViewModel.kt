package com.emreakcadag.baseandroid.feature.tweetdetail.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.SingleLiveData
import com.emreakcadag.data.entity.tweetdetail.TweetDetailViewEntity
import com.emreakcadag.data.entity.tweetdetail.TweetDetailViewEntity.Companion.fromResponse
import com.emreakcadag.domain.usecase.common.LogoutUseCase
import com.emreakcadag.domain.usecase.tweetdetail.GetTweetDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 12.03.2022
 */
@HiltViewModel
class TweetDetailViewModel @Inject constructor(
    private val getTweetDetailUseCase: GetTweetDetailUseCase,
    private val logoutUseCase: LogoutUseCase,
) : BaseViewModel() {

    val tweetDetailObservable = ObservableField<TweetDetailViewEntity>()

    private val _logoutLiveData = SingleLiveData<Unit>()
    val logoutLiveData: LiveData<Unit> = _logoutLiveData

    override fun onInit() {}

    fun getTweetDetail(tweetDetailViewEntity: TweetDetailViewEntity?) {
        tweetDetailObservable.set(tweetDetailViewEntity)
        getTweetDetailUseCase.execute()
            .onSuccess {
                tweetDetailObservable.set(it.fromResponse())
            }.subscribe()
    }

    fun onLogoutClick() {
        logoutUseCase.execute().withProgressBar().onSuccess {
            _logoutLiveData.value = Unit
        }.subscribe()
    }
}