package com.emreakcadag.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emreakcadag.network.ApiResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by Emre Akçadağ on 27.02.2022
 */
abstract class BaseViewModel : ViewModel() {

    private val loading = MutableLiveData<Boolean?>(null)

    abstract fun onInit()

    private fun resetProgressBarStatus(loading: Boolean? = true) {
        this.loading.value = loading == true
    }

    fun getProgressBarLiveData() = loading

    protected fun <T> Flow<ApiResult<T?>>.subscribe() = launchIn(viewModelScope)

    protected fun <T> Flow<ApiResult<T?>>.withProgressBar() = onEach {
        resetProgressBarStatus(it is ApiResult.Loading)
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