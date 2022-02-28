package com.emreakcadag.network

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
sealed class ApiResult<out Data> {

    data class Success<out Data>(val data: Data) : ApiResult<Data>()
    data class Error(val throwable: Throwable) : ApiResult<Nothing>()
    object Loading : ApiResult<Nothing>()
}