package com.emreakcadag.baseandroid.feature.splash.ui

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.baseandroid.R
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
        textObservable.set("SPLASH FRAGMENT")
    }

    fun navigateOnStartUp(onNavigate: (Int) -> Unit) {
        remoteConfig.initialize {
            dataStoreGetValueUseCase.execute(BaseDataStore.PreferenceKey.token).onSuccess {
                val navigationResId = if (it.isNullOrEmpty()) {
                    R.id.action_splashFragment_to_loginFragment
                } else {
                    R.id.action_splashFragment_to_tweetListFragment
                }

                onNavigate(navigationResId)
            }.onError {
                onNavigate(R.id.action_splashFragment_to_loginFragment)
            }.subscribe()
        }
    }
}