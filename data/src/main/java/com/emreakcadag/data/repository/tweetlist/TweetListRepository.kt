package com.emreakcadag.data.repository.tweetlist

import com.emreakcadag.common.ApiResult
import com.emreakcadag.data.dbentity.TweetListDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
interface TweetListRepository {

    fun getTweetList(query: String?, nextToken: String?): Flow<ApiResult.Success<TweetListDbEntity?>>
}