package com.emreakcadag.data.network.interceptor

import okhttp3.Interceptor
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
class HeaderInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain) =
        chain.proceed(chain.request().newBuilder().also {
            val idToken: String? = "TOKEN"
            it.takeIf { idToken.isNullOrBlank().not() }?.addHeader("Authorization", "Bearer $idToken")
        }.build())
}