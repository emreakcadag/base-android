package com.emreakcadag.domain.usecase.base

import android.util.Log
import com.emreakcadag.common.ApiResult
import com.emreakcadag.common.BuildConfig
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseFlowUseCase<in Params, Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    protected abstract fun onExecute(params: Params?): Flow<ApiResult<Result>>

    fun execute(params: Params? = null) = onExecute(params)
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
            if (BuildConfig.DEBUG) {
                Log.e(BaseFlowUseCase::class.java.name, "${throwable.message}")
            }
        }
        .flowOn(dispatcher)
}