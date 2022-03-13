package com.emreakcadag.data.repository

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.common.ApiResult
import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.DataStoreDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class DataStoreRepository @Inject constructor(
    private val dataStoreDataSource: DataStoreDataSource,
) : BaseRepository() {

    fun <T> setValue(key: Preferences.Key<T>?, value: T?) = fetch {
        dataStoreDataSource.setValue(key, value)
    }

    fun <T> getValue(key: Preferences.Key<T>?) = fetch {
        dataStoreDataSource.getValue(key)
    }
}