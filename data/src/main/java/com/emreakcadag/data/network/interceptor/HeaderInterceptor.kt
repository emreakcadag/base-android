package com.emreakcadag.data.network.interceptor

import com.emreakcadag.data.datastore.BaseDataStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
class HeaderInterceptor @Inject constructor(
    private val baseDataStore: BaseDataStore,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain) =
        chain.proceed(chain.request().newBuilder().also {
            val token = runBlocking { baseDataStore.getValue(BaseDataStore.PreferenceKey.token) }
            it.takeIf { !token.isNullOrBlank() }?.addHeader(HeaderType.AUTHORIZATION.name, "Bearer $token")
        }.build())

    enum class HeaderType(name: String) {
        AUTHORIZATION("Authorization"),
    }
}