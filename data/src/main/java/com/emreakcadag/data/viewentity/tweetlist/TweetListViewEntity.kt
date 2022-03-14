package com.emreakcadag.data.viewentity.tweetlist

import android.os.Parcelable
import com.emreakcadag.data.response.TweetListResponse
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Parcelize
data class TweetListViewEntity(
    val tweetList: List<TweetViewEntity>?,
    val nextToken: String?,
) : Parcelable {

    companion object {

        fun TweetListResponse?.fromResponse() = this?.run {
            TweetListViewEntity(
                tweetList = tweetList?.map {
                    val user = tweetIncludes?.users?.firstOrNull { user -> user.id == it.authorId }

                    TweetViewEntity(
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
    }
}