package com.emreakcadag.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.firstOrNull

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
open class BaseDataStore constructor(
    private val dataStore: DataStore<Preferences>
) {

    suspend fun <T> setValue(key: Preferences.Key<T>?, value: T?) {
        if (key != null && value != null) {
            dataStore.edit { it[key] = value }
        }
    }

    suspend fun <T> getValue(key: Preferences.Key<T>?): T? = key?.run { dataStore.data.firstOrNull()?.get(key) }

    object PreferenceKey {

        val token = stringPreferencesKey("token")
    }
}