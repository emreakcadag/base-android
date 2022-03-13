package com.emreakcadag.data

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import com.emreakcadag.data.datastore.BaseDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object LocaleModule {

    private const val DATA_STORE_APP = "app"

    @Provides
    @Singleton
    fun provideBaseDataStore(@ApplicationContext appContext: Context) =
        BaseDataStore(PreferenceDataStoreFactory.create(produceFile = { appContext.preferencesDataStoreFile(DATA_STORE_APP) }))
}