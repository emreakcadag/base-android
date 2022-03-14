package com.emreakcadag.data.dbentity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emreakcadag.data.response.TweetDetailResponse

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
@Entity(tableName = "tweet")
data class TweetDbEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "text") val text: String?,
    @ColumnInfo(name = "author_id") val authorId: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "profile_image_url") val profileImageUrl: String?,
) {

    companion object {

        fun TweetDetailResponse?.fromResponse() = this?.run {
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
    }
}