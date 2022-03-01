package com.emreakcadag.network

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseFlowUseCase<in Param, out Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    protected abstract fun execute(params: Param): Flow<ApiResult<Result>>

    operator fun invoke(param: Param) = execute(param)
        .onStart {
            emit(ApiResult.Loading)
        }
        .retry(3) { exception ->
            (exception is Exception).also { if (it) delay(1000) }
        }
        .catch { throwable ->
            emit(ApiResult.Error(throwable))
        }
        .flowOn(dispatcher)
}