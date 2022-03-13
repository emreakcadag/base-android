package com.emreakcadag.data.apiservice

import com.emreakcadag.data.response.TweetListResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
interface TweetListApiService {

    @GET("2/tweets/search/recent")
    suspend fun getTweetList(
        @Query("query") query: String?,
        @Query("next_token") nextToken: String?,
    ): TweetListResponse
}