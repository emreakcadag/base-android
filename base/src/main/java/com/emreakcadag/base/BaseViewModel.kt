package com.emreakcadag.base

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreakcadag.common.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Emre Akçadağ on 27.02.2022
 */

private val loadingVisibilityObservable = ObservableBoolean()

abstract class BaseViewModel : ViewModel() {

    val loadingObservable = loadingVisibilityObservable

    abstract fun onInit()

    protected fun <T> Flow<ApiResult<T?>>.subscribe() = launchIn(viewModelScope)

    protected fun <T> Flow<ApiResult<T?>>.withProgressBar() = onEach {
        loadingObservable.set(it is ApiResult.Loading)
    }

    inline fun <T> Flow<ApiResult<T?>>.onSuccess(crossinline action: suspend (T?) -> Unit) = onEach {
        if (it is ApiResult.Success) {
            action(it.data)
        }
    }

    inline fun <T> Flow<ApiResult<T?>>.onError(crossinline action: suspend (Throwable) -> Unit) = onEach {
        if (it is ApiResult.Error) {
            action(it.throwable)
        }
    }
}