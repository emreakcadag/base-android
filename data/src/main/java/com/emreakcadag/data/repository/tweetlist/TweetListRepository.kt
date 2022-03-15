package com.emreakcadag.data.repository.tweetlist

import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.TweetListDataSource
import com.emreakcadag.data.mapper.TweetListMapper
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class TweetListRepository @Inject constructor(
    private val tweetListDataSource: TweetListDataSource,
    private val mapper: TweetListMapper,
) : BaseRepository() {

    fun getTweetList(query: String?, nextToken: String?) = fetch {
        tweetListDataSource.getTweetList(query, nextToken).let {
            mapper.responseToDbEntity(it)
        }
    }
}