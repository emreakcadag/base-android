package com.emreakcadag.data.repository

import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.tweetdetail.TweetDetailLocalDataSource
import com.emreakcadag.data.datasource.tweetdetail.TweetDetailRemoteDataSource
import com.emreakcadag.data.dbentity.TweetDbEntity.Companion.fromResponse
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetDetailRepository @Inject constructor(
    private val tweetDetailRemoteDataSource: TweetDetailRemoteDataSource,
    private val tweetDetailLocalDataSource: TweetDetailLocalDataSource,
) : BaseRepository() {

    fun getTweetDetail(id: String?) = fetch {
        tweetDetailLocalDataSource.getLocalTweetById(id) ?: tweetDetailRemoteDataSource.getTweetDetail(id).let {
            tweetDetailLocalDataSource.insertLocalTweet(it.fromResponse())
        }
    }
}