package com.emreakcadag.data.repository.tweetdetail

import com.emreakcadag.common.ApiResult
import com.emreakcadag.data.dbentity.TweetDbEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
interface TweetDetailRepository {

    fun getTweetDetail(id: String?): Flow<ApiResult.Success<TweetDbEntity?>>
}