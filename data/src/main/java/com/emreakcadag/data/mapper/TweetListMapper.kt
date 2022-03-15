package com.emreakcadag.data.mapper

import com.emreakcadag.data.base.EntityMapper
import com.emreakcadag.data.dbentity.TweetListDbEntity
import com.emreakcadag.data.response.TweetListResponse
import com.emreakcadag.data.viewentity.tweetlist.TweetItemViewEntity
import com.emreakcadag.data.viewentity.tweetlist.TweetListViewEntity
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 15.03.2022
 */
class TweetListMapper @Inject constructor() : EntityMapper<TweetListResponse, TweetListDbEntity, TweetListViewEntity> {

    override fun responseToDbEntity(response: TweetListResponse?) = response?.run {
        TweetListDbEntity(
            tweetItemList = tweetList?.map {
                val user = tweetIncludes?.users?.firstOrNull { user -> user.id == it.authorId }

                TweetItemViewEntity(
                    id = it.id,
                    text = it.text,
                    authorId = it.authorId,
                    username = user?.username,
                    name = user?.name,
                    profileImageUrl = user?.profileImageUrl,
                )
            },
            nextToken = tweetMetaModel?.nextToken,
        )
    }

    override fun dbEntityToViewEntity(entity: TweetListDbEntity?) = entity?.run {
        TweetListViewEntity(
            tweetItemList = tweetItemList,
            nextToken = nextToken,
        )
    }
}