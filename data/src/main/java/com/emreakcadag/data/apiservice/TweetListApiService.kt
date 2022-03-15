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
        @Query("expansions") expansions: String? = "author_id",
        @Query("user.fields") userFields: String? = "profile_image_url",
        @Query("max_results") maxResult: Int? = 15,
    ): TweetListResponse
}