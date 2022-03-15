package com.emreakcadag.baseandroid.feature.tweetdetail

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.baseandroid.extension.setBaseUrlAndCreateRetrofit
import com.emreakcadag.data.apiservice.TweetDetailApiService
import com.emreakcadag.data.datasource.tweetdetail.TweetDetailLocalDataSource
import com.emreakcadag.data.datasource.tweetdetail.TweetDetailRemoteDataSource
import com.emreakcadag.data.mapper.TweetDetailMapper
import com.emreakcadag.data.repository.tweetdetail.TweetDetailRepository
import com.emreakcadag.data.repository.tweetdetail.TweetDetailRepositoryImpl
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
object TweetDetailModule {

    @Provides
    @ViewModelScoped
    fun provideTweetDetailApiService(
        retrofitBuilder: Retrofit.Builder,
        remoteConfig: RemoteConfig,
    ) = retrofitBuilder
        .setBaseUrlAndCreateRetrofit<TweetDetailApiService>(remoteConfig)

    @Provides
    @ViewModelScoped
    fun provideTweetDetailRepository(
        tweetDetailLocalDataSource: TweetDetailLocalDataSource,
        tweetDetailRemoteDataSource: TweetDetailRemoteDataSource,
        tweetDetailMapper: TweetDetailMapper,
    ): TweetDetailRepository = TweetDetailRepositoryImpl(tweetDetailRemoteDataSource, tweetDetailLocalDataSource, tweetDetailMapper)
}