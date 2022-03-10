package com.emreakcadag.data.apiservice

import com.emreakcadag.data.response.MainResponse
import retrofit2.http.GET

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
interface MainApiService {

    // data: "https://mocki.io/v1/54caa4f8-d217-4230-b234-91ddfc8be731"
    // "https://mocki.io/v1/e4ecd287-a65d-4211-86ff-84321c6537be"
    @GET("https://mocki.io/v1/e4ecd287-a65d-4211-86ff-84321c6537be")
    suspend fun getMainData(): MainResponse?
}