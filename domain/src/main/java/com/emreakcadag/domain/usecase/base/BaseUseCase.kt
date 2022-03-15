package com.emreakcadag.domain.usecase.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseUseCase<in Params, out Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(params: Params? = null) = runCatching {
        withContext(dispatcher) {
            execute(params)
        }
    }.getOrElse {
        it
    }

    protected abstract suspend fun execute(params: Params?): Result
}