package com.emreakcadag.baseandroid.feature.login

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 12.03.2022
 */
@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("Login Fragment")
    }
}