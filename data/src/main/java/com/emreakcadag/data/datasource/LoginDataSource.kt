package com.emreakcadag.data.datasource

import com.emreakcadag.data.apiservice.LoginApiService
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class LoginDataSource @Inject constructor(
    private val loginApiService: LoginApiService,
) {

    suspend fun login(authorization: String?, grantType: String?) = loginApiService.login(authorization, grantType)
}