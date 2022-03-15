package com.emreakcadag.baseandroid.extension

import com.emreakcadag.base.firebase.remoteconfig.RemoteConfig
import com.emreakcadag.base.firebase.remoteconfig.RemoteConfigParameter
import retrofit2.Retrofit

/**
 * Created by Emre Akçadağ on 10.03.2022
 */

inline fun <reified T> Retrofit.Builder.setBaseUrlAndCreateRetrofit(
    remoteConfig: RemoteConfig,
    key: RemoteConfigParameter = RemoteConfigParameter.BASE_URL
): T = this
    .baseUrl(remoteConfig.getString(key))
    .build()
    .create(T::class.java)
