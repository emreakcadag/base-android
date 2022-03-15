package com.emreakcadag.domain.usecase.tweetdetail

import com.emreakcadag.data.dbentity.TweetDbEntity
import com.emreakcadag.data.repository.tweetdetail.TweetDetailRepository
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class GetTweetDetailUseCase @Inject constructor(
    private val tweetDetailRepository: TweetDetailRepository,
) : BaseFlowUseCase<String?, TweetDbEntity?>() {

    override fun onExecute(params: String?) = tweetDetailRepository.getTweetDetail(params)
}