package com.emreakcadag.baseandroid.feature.login

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.baseandroid.extension.setBaseUrlAndCreateRetrofit
import com.emreakcadag.data.apiservice.LoginApiService
import com.emreakcadag.data.datasource.LoginDataSource
import com.emreakcadag.data.repository.login.LoginRepository
import com.emreakcadag.data.repository.login.LoginRepositoryImpl
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
object LoginModule {

    @Provides
    @ViewModelScoped
    fun provideLoginApiService(
        retrofitBuilder: Retrofit.Builder,
        remoteConfig: RemoteConfig,
    ) = retrofitBuilder
        .setBaseUrlAndCreateRetrofit<LoginApiService>(remoteConfig)

    @Provides
    @ViewModelScoped
    fun provideLoginRepository(
        loginDataSource: LoginDataSource
    ): LoginRepository = LoginRepositoryImpl(loginDataSource)
}