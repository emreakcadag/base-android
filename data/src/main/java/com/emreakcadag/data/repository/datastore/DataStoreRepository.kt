package com.emreakcadag.data.repository.datastore

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.common.ApiResult
import kotlinx.coroutines.flow.Flow

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
interface DataStoreRepository {

    fun <T> getValue(key: Preferences.Key<T>?): Flow<ApiResult.Success<T?>>

    fun <T> setValue(key: Preferences.Key<T>?, value: T?): Flow<ApiResult.Success<Unit?>>
}