package com.emreakcadag.data

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import com.emreakcadag.data.datasource.DataStoreDataSource
import com.emreakcadag.data.datastore.BaseDataStore
import com.emreakcadag.data.repository.datastore.DataStoreRepository
import com.emreakcadag.data.repository.datastore.DataStoreRepositoryImpl
import com.emreakcadag.data.room.AppDatabase
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
object DataModule {

    private const val DATA_STORE_APP = "app_data_store"
    private const val DATA_BASE_APP = "app_data_base"

    @Provides
    @Singleton
    fun provideBaseDataStore(@ApplicationContext appContext: Context) = BaseDataStore(
        PreferenceDataStoreFactory.create(produceFile = { appContext.preferencesDataStoreFile(DATA_STORE_APP) })
    )

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context) = Room
        .databaseBuilder(appContext, AppDatabase::class.java, DATA_BASE_APP)
        .build()

    @Provides
    @Singleton
    fun provideTweetDao(appDatabase: AppDatabase) = appDatabase.tweetDao()

    @Provides
    @Singleton
    fun provideDataStoreRepository(dataStoreDataSource: DataStoreDataSource): DataStoreRepository = DataStoreRepositoryImpl(dataStoreDataSource)
}