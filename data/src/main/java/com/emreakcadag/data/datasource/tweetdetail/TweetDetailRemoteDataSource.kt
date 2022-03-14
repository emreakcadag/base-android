package com.emreakcadag.data.datasource.tweetdetail

import com.emreakcadag.data.apiservice.TweetDetailApiService
import com.emreakcadag.data.dao.TweetDao
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetDetailRemoteDataSource @Inject constructor(
    private val tweetDetailApiService: TweetDetailApiService,
) {

    suspend fun getTweetDetail(id: String?) = tweetDetailApiService.getTweetDetail(id)
}