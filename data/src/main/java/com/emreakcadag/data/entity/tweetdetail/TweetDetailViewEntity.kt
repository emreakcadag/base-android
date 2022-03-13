package com.emreakcadag.data.entity.tweetdetail

import android.os.Parcelable
import com.emreakcadag.data.response.TweetDetailResponse
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
@Parcelize
data class TweetDetailViewEntity(
    val id: String?,
    val text: String?,
    val authorId: String?,
    val username: String?,
    val name: String?,
    val profileImageUrl: String?,
) : Parcelable {

    companion object {

        fun TweetDetailResponse?.fromResponse() = this?.run {
            val user = tweetIncludes?.users?.firstOrNull { user -> user.id == tweet?.authorId }

            TweetDetailViewEntity(
                id = tweet?.id,
                text = tweet?.text,
                authorId = tweet?.authorId,
                username = user?.username,
                name = user?.name,
                profileImageUrl = user?.profileImageUrl,
            )
        }
    }
}