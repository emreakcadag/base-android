package com.emreakcadag.baseandroid.feature.fragment2

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class SecondViewModel @Inject constructor() : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("SECOND FRAGMENT")
    }
}