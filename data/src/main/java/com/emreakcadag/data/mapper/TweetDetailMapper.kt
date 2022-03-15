package com.emreakcadag.data.mapper

import com.emreakcadag.data.base.EntityMapper
import com.emreakcadag.data.dbentity.TweetDbEntity
import com.emreakcadag.data.response.TweetDetailResponse
import com.emreakcadag.data.viewentity.tweetdetail.TweetDetailViewEntity
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
class TweetDetailMapper @Inject constructor() : EntityMapper<TweetDetailResponse, TweetDbEntity, TweetDetailViewEntity> {

    override fun responseToDbEntity(response: TweetDetailResponse?) = response?.run {
        tweet?.id?.let {
            val user = tweetIncludes?.users?.firstOrNull { user -> user.id == tweet.authorId }
            TweetDbEntity(
                id = tweet.id,
                text = tweet.text,
                authorId = tweet.authorId,
                username = user?.username,
                name = user?.name,
                profileImageUrl = user?.profileImageUrl,
            )
        }
    }

    override fun dbEntityToViewEntity(entity: TweetDbEntity?) = entity?.run {
        TweetDetailViewEntity(
            id = id,
            text = text,
            authorId = authorId,
            username = username,
            name = name,
            profileImageUrl = profileImageUrl,
        )
    }
}