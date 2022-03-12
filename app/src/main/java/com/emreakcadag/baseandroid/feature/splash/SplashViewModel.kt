package com.emreakcadag.baseandroid.feature.splash

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val remoteConfig: RemoteConfig,
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("SPLASH FRAGMENT")
    }

    fun navigateOnStartUp(onContinue: (Boolean) -> Unit) {
        remoteConfig.initialize {
            onContinue(it)
        }
    }
}