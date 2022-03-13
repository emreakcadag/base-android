package com.emreakcadag.data.entity.tweetlist

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
                tweetList = tweetList?.map { TweetViewEntity(id = it.id, text = it.text) },
                nextToken = tweetMetaModel?.nextToken,
            )
        }
    }
}