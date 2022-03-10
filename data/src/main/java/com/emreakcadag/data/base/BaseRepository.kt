package com.emreakcadag.data.base

import com.emreakcadag.common.ApiResult
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