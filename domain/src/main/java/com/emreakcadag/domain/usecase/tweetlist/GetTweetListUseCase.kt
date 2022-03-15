package com.emreakcadag.domain.usecase.tweetlist

import com.emreakcadag.data.dbentity.TweetListDbEntity
import com.emreakcadag.data.repository.TweetListRepository
import com.emreakcadag.data.response.TweetListResponse
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class GetTweetListUseCase @Inject constructor(
    private val tweetListRepository: TweetListRepository,
) : BaseFlowUseCase<GetTweetListUseCase.Params?, TweetListDbEntity?>() {

    override fun onExecute(params: Params?) = tweetListRepository.getTweetList(params?.query, params?.nextToken)

    data class Params(val query: String?, val nextToken: String?)
}