package com.emreakcadag.data.repository

import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.TweetDetailDataSource
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetDetailRepository @Inject constructor(
    private val tweetDetailDataSource: TweetDetailDataSource,
) : BaseRepository() {

    fun getTweetDetail(id: String?) = fetch {
        tweetDetailDataSource.getTweetDetail(id)
    }
}