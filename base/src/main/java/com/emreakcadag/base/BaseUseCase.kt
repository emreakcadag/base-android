package com.emreakcadag.base

import com.emreakcadag.extension.logDebug
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
abstract class BaseUseCase<in Param, out Result>(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(param: Param? = null) = runCatching {
        withContext(dispatcher) {
            execute(param)
        }
    }.getOrElse {
        logDebug(it.message, isError = true)
        it
    }

    protected abstract suspend fun execute(param: Param?): Result
}