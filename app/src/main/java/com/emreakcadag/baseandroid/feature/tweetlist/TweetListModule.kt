package com.emreakcadag.baseandroid.feature.tweetlist

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.baseandroid.extension.setBaseUrlAndCreateRetrofit
import com.emreakcadag.data.apiservice.TweetListApiService
import com.emreakcadag.data.datasource.TweetListDataSource
import com.emreakcadag.data.mapper.TweetListMapper
import com.emreakcadag.data.repository.tweetlist.TweetListRepository
import com.emreakcadag.data.repository.tweetlist.TweetListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Module
@InstallIn(ViewModelComponent::class)
object TweetListModule {

    @Provides
    @ViewModelScoped
    fun provideTweetListApiService(
        retrofitBuilder: Retrofit.Builder,
        remoteConfig: RemoteConfig,
    ) = retrofitBuilder
        .setBaseUrlAndCreateRetrofit<TweetListApiService>(remoteConfig)

    @Provides
    @ViewModelScoped
    fun provideTweetListRepository(
        tweetListDataSource: TweetListDataSource,
        tweetListMapper: TweetListMapper,
    ): TweetListRepository = TweetListRepositoryImpl(tweetListDataSource, tweetListMapper)
}