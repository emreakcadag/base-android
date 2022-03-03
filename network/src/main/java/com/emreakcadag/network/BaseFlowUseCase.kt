package com.emreakcadag.network

import com.emreakcadag.extension.logDebug
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseFlowUseCase<in Param, Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    protected abstract fun onExecute(param: Param?): Flow<ApiResult<Result>>

    fun execute(param: Param? = null) = onExecute(param)
        .onStart {
            emit(ApiResult.Loading)
        }
        .retry(3) { e ->
            (e is Exception).also {
                if (it) delay(1000)
            }
        }
        .catch { throwable ->
            emit(ApiResult.Error(throwable))
            logDebug(throwable.message, isError = true)
        }
        .flowOn(dispatcher)
}