package com.emreakcadag.data.repository.login

import com.emreakcadag.common.ApiResult
import com.emreakcadag.data.response.LoginResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
interface LoginRepository {

    fun login(authorization: String?, grantType: String?): Flow<ApiResult.Success<LoginResponse?>>
}