package com.emreakcadag.data.repository.datastore

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.DataStoreDataSource
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class DataStoreRepositoryImpl @Inject constructor(
    private val dataStoreDataSource: DataStoreDataSource,
) : BaseRepository(), DataStoreRepository {

    override
    fun <T> setValue(key: Preferences.Key<T>?, value: T?) = fetch {
        dataStoreDataSource.setValue(key, value)
    }

    override
    fun <T> getValue(key: Preferences.Key<T>?) = fetch {
        dataStoreDataSource.getValue(key)
    }
}