package com.emreakcadag.data.repository.login

import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.LoginDataSource
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class LoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource,
) : BaseRepository(), LoginRepository {

    override
    fun login(authorization: String?, grantType: String?) = fetch {
        loginDataSource.login(authorization, grantType)
    }
}