package com.emreakcadag.baseandroid.feature.login.ui

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.baseandroid.R
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
) : BaseViewModel() {

    val usernameObservable = ObservableField("X70aslvBC6F2Z2LUISlU3XjFi")
    val passwordObservable = ObservableField("8lfrGMkONqnTFSRsnBzcnTgc5aPvZP9O4zxndEMKUXFjh03KkD")

    override fun onInit() {}

    fun onUsernameChanged(text: String?) {
        usernameObservable.set(text)
    }

    fun onPasswordChanged(text: String?) {
        passwordObservable.set(text)
    }

    fun login(onNavigate: (Int) -> Unit) {
        loginUseCase.execute(
            LoginUseCase.Params(getLoginCredentials())
        ).withProgressBar()
            .onSuccess {
                saveAccessToken(it?.accessToken)
                onNavigate(R.id.action_loginFragment_to_tweetListFragment)
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