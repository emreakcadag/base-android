package com.emreakcadag.base

import com.example.extension.logDebug
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseUseCase<in Param, out Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(params: Param) = runCatching {
        withContext(dispatcher) {
            execute(params)
        }
    }.getOrElse {
        logDebug(it.message, isError = true)
        it
    }

    protected abstract suspend fun execute(params: Param): Result
}