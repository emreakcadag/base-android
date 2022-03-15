package com.emreakcadag.data.apiservice

import com.emreakcadag.data.response.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
interface LoginApiService {

    @FormUrlEncoded
    @POST("oauth2/token")
    suspend fun login(
        @Header("Authorization") authorization: String?,
        @Field("grant_type") grantType: String?
    ): LoginResponse
}