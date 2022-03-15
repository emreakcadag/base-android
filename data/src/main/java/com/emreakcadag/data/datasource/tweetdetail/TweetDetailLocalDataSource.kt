package com.emreakcadag.data.datasource.tweetdetail

import com.emreakcadag.data.dao.TweetDao
import com.emreakcadag.data.dbentity.TweetDbEntity
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
class TweetDetailLocalDataSource @Inject constructor(
    private val tweetDao: TweetDao,
) {

    fun getLocalTweetById(id: String?) = id?.let { tweetDao.findById(it) }

    fun insertLocalTweet(tweetDbEntity: TweetDbEntity?) = tweetDbEntity?.also { tweetDao.insertAll(it) }
}