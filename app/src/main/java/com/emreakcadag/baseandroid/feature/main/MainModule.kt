package com.emreakcadag.baseandroid.feature.main

import com.emreakcadag.data.apiservice.MainApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
@Module
@InstallIn(ViewModelComponent::class)
object MainModule {

    @Provides
    @ViewModelScoped
    fun provideMainApiService(
        retrofitBuilder: Retrofit.Builder,
    ) = retrofitBuilder
        .baseUrl("https://exapmle.com/")
        .build()
        .create(MainApiService::class.java)
}