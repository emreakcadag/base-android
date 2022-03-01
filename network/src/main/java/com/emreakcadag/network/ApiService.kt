package com.emreakcadag.network

import retrofit2.http.GET

/**
 * Created by Emre Akçadağ on 1.03.2022
 */
interface ApiService {

    @GET("euehe/asdsa")
    suspend fun getMainData(): ApiResult<String>
}