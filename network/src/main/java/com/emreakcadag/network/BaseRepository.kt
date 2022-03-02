package com.emreakcadag.network

import kotlinx.coroutines.flow.flow

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
open class BaseRepository {

    protected fun <T> fetch(apiCall: suspend () -> T?) = flow {
        val response = apiCall()
        emit(ApiResult.Success(response))
    }
}