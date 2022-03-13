package com.emreakcadag.data.datasource

import com.emreakcadag.data.apiservice.TweetListApiService
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetListDataSource @Inject constructor(
    private val tweetListApiService: TweetListApiService,
) {

    suspend fun getTweetList(query: String?, nextToken: String?) = tweetListApiService.getTweetList(query, nextToken)
}