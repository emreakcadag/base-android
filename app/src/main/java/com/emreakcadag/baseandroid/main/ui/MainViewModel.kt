package com.emreakcadag.baseandroid.main.ui

import android.util.Log
import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.domain.usecase.main.GetMainDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 27.02.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMainDataUseCase: GetMainDataUseCase,
    private val remoteConfig: RemoteConfig,
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        getMainDataUseCase.execute().withProgressBar().onSuccess {
            textObservable.set(it?.emre)
            Log.e("EMREE", "${remoteConfig.getString("emre")}")
        }.onError {
            Log.e("EMREE", it.toString())
        }.subscribe()
    }
}