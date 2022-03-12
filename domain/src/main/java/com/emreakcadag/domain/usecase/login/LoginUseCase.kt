package com.emreakcadag.domain.usecase.login

import com.emreakcadag.data.repository.LoginRepository
import com.emreakcadag.data.response.LoginResponse
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository,
) : BaseFlowUseCase<LoginUseCase.Params?, LoginResponse?>() {

    override fun onExecute(params: Params?) = loginRepository.login(params?.authorization, params?.grantType)

    data class Params(val authorization: String?, val grantType: String? = "client_credentials")
}