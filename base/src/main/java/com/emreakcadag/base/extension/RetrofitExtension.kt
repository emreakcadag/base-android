package com.emreakcadag.base.extension

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.data.BuildConfig
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 08.03.2022
 */

inline fun <reified T> Retrofit.Builder.setBaseUrl(remoteConfig: RemoteConfig, key: String = "baseUrl"): T = this
    .baseUrl(remoteConfig.getString(key) ?: BuildConfig.BASE_URL)
    .build()
    .create(T::class.java)