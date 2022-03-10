package com.emreakcadag.baseandroid.extension

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 10.03.2022
 */

inline fun <reified T> Retrofit.Builder.setBaseUrlAndCreateRetrofit(remoteConfig: RemoteConfig, key: String = "baseUrl"): T = this
    .baseUrl(remoteConfig.getString(key))
    .build()
    .create(T::class.java)
