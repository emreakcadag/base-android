package com.emreakcadag.base.firebase

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfigImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Emre Akçadağ on 08.03.2022
 */
@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideRemoteConfig(): RemoteConfig = RemoteConfigImpl()
}