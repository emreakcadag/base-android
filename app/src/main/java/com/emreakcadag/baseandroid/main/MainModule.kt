package com.emreakcadag.baseandroid.main

import com.emreakcadag.baseandroid.main.data.MainApiService
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
    fun provideMainApiService(retrofit: Retrofit) = retrofit.create(MainApiService::class.java)
}