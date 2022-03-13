package com.emreakcadag.data.datasource

import com.emreakcadag.data.apiservice.TweetDetailApiService
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetDetailDataSource @Inject constructor(
    private val tweetDetailApiService: TweetDetailApiService,
) {

    suspend fun getTweetDetail(id: String?) = tweetDetailApiService.getTweetDetail(id)
}