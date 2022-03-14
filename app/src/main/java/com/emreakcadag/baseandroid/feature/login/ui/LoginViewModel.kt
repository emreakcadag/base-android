package com.emreakcadag.baseandroid.feature.login.ui

import androidx.databinding.ObservableField
import androidx.navigation.NavDirections
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfigParameter
import com.emreakcadag.data.datastore.BaseDataStore
import com.emreakcadag.domain.usecase.common.DataStoreSetValueUseCase
import com.emreakcadag.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import okhttp3.Credentials
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 12.03.2022
 */
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val dataStoreSetValueUseCase: DataStoreSetValueUseCase<String>,
    remoteConfig: RemoteConfig,
) : BaseViewModel() {

    val usernameObservable = ObservableField(remoteConfig.getString(RemoteConfigParameter.USERNAME))
    val passwordObservable = ObservableField(remoteConfig.getString(RemoteConfigParameter.PASSWORD))

    override fun onInit() {}

    fun onUsernameChanged(text: String?) {
        usernameObservable.set(text)
    }

    fun onPasswordChanged(text: String?) {
        passwordObservable.set(text)
    }

    fun login(onNavigate: (NavDirections) -> Unit) {
        loginUseCase.execute(
            LoginUseCase.Params(getLoginCredentials())
        ).withProgressBar()
            .onSuccess {
                saveAccessToken(it?.accessToken)
                onNavigate(LoginFragmentDirections.actionLoginFragmentToTweetListFragment())
            }
            .subscribe()
    }

    private fun saveAccessToken(accessToken: String?) {
        dataStoreSetValueUseCase.execute(DataStoreSetValueUseCase.Params(BaseDataStore.PreferenceKey.token, accessToken)).subscribe()
    }

    private fun getLoginCredentials() = Credentials.basic(
        usernameObservable.get().toString(),
        passwordObservable.get().toString(),
        Charsets.UTF_8
    )
}