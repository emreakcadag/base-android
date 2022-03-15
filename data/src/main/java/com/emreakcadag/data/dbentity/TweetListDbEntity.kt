package com.emreakcadag.data.dbentity

import com.emreakcadag.data.viewentity.tweetlist.TweetItemViewEntity

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
// todo emreakcadag make @Entity when needed local db.
data class TweetListDbEntity(
    val tweetItemList: List<TweetItemViewEntity>?,
    val nextToken: String?,
)