package com.emreakcadag.baseandroid.feature.tweetlist

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class TweetListViewModel @Inject constructor() : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("Tweet List Fragment")
    }
}