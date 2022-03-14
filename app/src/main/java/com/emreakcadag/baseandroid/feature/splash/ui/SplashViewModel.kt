package com.emreakcadag.baseandroid.feature.splash.ui

import androidx.databinding.ObservableField
import androidx.navigation.NavDirections
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.data.datastore.BaseDataStore
import com.emreakcadag.domain.usecase.common.DataStoreGetValueUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 10.03.2022
 */
@HiltViewModel
class SplashViewModel @Inject constructor(
    private val remoteConfig: RemoteConfig,
    private val dataStoreGetValueUseCase: DataStoreGetValueUseCase<String>,
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("SPLASH")
    }

    fun navigateOnStartUp(onNavigate: (NavDirections) -> Unit) {
        remoteConfig.initialize {
            dataStoreGetValueUseCase.execute(BaseDataStore.PreferenceKey.token).onSuccess {
                val navigationResId = if (it.isNullOrEmpty()) {
                    SplashFragmentDirections.actionSplashFragmentToLoginFragment()
                } else {
                    SplashFragmentDirections.actionSplashFragmentToTweetListFragment()
                }

                onNavigate(navigationResId)
            }.onError {
                onNavigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }.subscribe()
        }
    }
}