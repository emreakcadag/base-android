package com.emreakcadag.baseandroid.feature.login.ui

import androidx.databinding.ObservableField
import com.emreakcadag.base.BaseViewModel
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
) : BaseViewModel() {

    val textObservable = ObservableField<String?>()

    override fun onInit() {
        textObservable.set("Login Fragment")
        login()
    }

    private fun login() {
        loginUseCase.execute(
            LoginUseCase.Params(getLoginCredentials())
        ).withProgressBar().onSuccess {
            textObservable.set(it?.accessToken)
        }.subscribe()
    }

    private fun getLoginCredentials() = Credentials.basic("X70aslvBC6F2Z2LUISlU3XjFi", "8lfrGMkONqnTFSRsnBzcnTgc5aPvZP9O4zxndEMKUXFjh03KkD", Charsets.UTF_8)
}