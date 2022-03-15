package com.emreakcadag.baseandroid.feature.tweetlist.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.SingleLiveData
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfigParameter
import com.emreakcadag.baseandroid.feature.tweetlist.ui.list.TweetListAdapter
import com.emreakcadag.data.mapper.TweetListMapper
import com.emreakcadag.data.viewentity.tweetlist.TweetItemViewEntity
import com.emreakcadag.data.viewentity.tweetlist.TweetListViewEntity
import com.emreakcadag.domain.usecase.common.LogoutUseCase
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
    private val logoutUseCase: LogoutUseCase,
    private val mapper: TweetListMapper,
    remoteConfig: RemoteConfig,
) : BaseViewModel() {

    val toolbarTitleObservable = ObservableField<String?>(remoteConfig.getString(RemoteConfigParameter.TOOLBAR_TITLE))
    val tweetListAdapterObservable = ObservableField<TweetListAdapter?>()
    val imageAssetObservable = ObservableField(remoteConfig.getString(RemoteConfigParameter.TOOLBAR_IMAGE_URL))

    private val tweetListAdapter = TweetListAdapter {
        _onItemClickLiveData.value = it
    }.also {
        tweetListAdapterObservable.set(it)
    }

    private var nextToken: String? = null
    private val tweetItemList: ArrayList<TweetItemViewEntity> = arrayListOf()

    private val _onItemClickLiveData = SingleLiveData<TweetItemViewEntity>()
    val onItemClickLiveData: LiveData<TweetItemViewEntity> = _onItemClickLiveData

    private val _logoutLiveData = SingleLiveData<Unit>()
    val logoutLiveData: LiveData<Unit> = _logoutLiveData

    override fun onInit() {
        getTweetListData()
    }

    fun getTweetListData() {
        getTweetListUseCase.execute(
            GetTweetListUseCase.Params(
                "pen",
                nextToken,
            )
        ).withProgressBar().onSuccess {
            mapper.dbEntityToViewEntity(it)?.let { viewEntity ->
                setTweetListAdapter(viewEntity)
                nextToken = viewEntity.nextToken
            }
        }.subscribe()
    }

    private fun setTweetListAdapter(tweetListViewEntity: TweetListViewEntity?) {
        tweetListViewEntity?.tweetItemList?.let { tweetItemList.addAll(it) }
        tweetListAdapter.submitList(tweetItemList.toImmutableList())
    }

    fun onLogoutClick() {
        logoutUseCase.execute().withProgressBar().onSuccess {
            _logoutLiveData.value = Unit
        }.subscribe()
    }
}