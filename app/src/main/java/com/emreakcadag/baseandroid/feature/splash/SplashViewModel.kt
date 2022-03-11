package com.emreakcadag.baseandroid.feature.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 08.03.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val remoteConfig: RemoteConfig,
) : BaseViewModel() {

    private val _navigateMainActivityLiveData = MutableLiveData<Boolean>()
    val navigateMainActivityLiveData: LiveData<Boolean> = _navigateMainActivityLiveData

    override fun onInit() {
        remoteConfig.initialize {
            _navigateMainActivityLiveData.value = it
        }
    }
}