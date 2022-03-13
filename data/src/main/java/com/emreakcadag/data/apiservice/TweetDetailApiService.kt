package com.emreakcadag.data.apiservice

import com.emreakcadag.data.response.TweetDetailResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
interface TweetDetailApiService {

    @GET("2/tweets/{id}")
    suspend fun getTweetDetail(
        @Path("id") id: String?,
        @Query("expansions") expansions: String? = "author_id",
        @Query("tweet.fields") tweetFields: String? = "author_id,source,created_at",
        @Query("user.fields") userFields: String? = "description,profile_image_url"
    ): TweetDetailResponse
}