package com.emreakcadag.baseandroid.feature.tweetdetail

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 12.03.2022
 */
@HiltViewModel
class TweetDetailViewModel @Inject constructor(
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("Tweet Detail Fragment")
    }
}