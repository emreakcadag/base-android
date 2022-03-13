package com.emreakcadag.data.datasource

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.data.datastore.BaseDataStore
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class DataStoreDataSource @Inject constructor(
    private val baseDataStore: BaseDataStore,
) {

    suspend fun <T> setValue(key: Preferences.Key<T>?, value: T?) = baseDataStore.setValue(key, value)

    suspend fun <T> getValue(key: Preferences.Key<T>?) = baseDataStore.getValue(key)
}