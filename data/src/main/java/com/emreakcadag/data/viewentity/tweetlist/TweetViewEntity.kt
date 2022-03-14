package com.emreakcadag.data.viewentity.tweetlist

import android.os.Parcelable
import com.emreakcadag.data.dbentity.TweetDbEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Parcelize
data class TweetViewEntity(
    val id: String?,
    val text: String?,
    val authorId: String?,
    val username: String?,
    val name: String?,
    val profileImageUrl: String?,
) : Parcelable {

    companion object {

        fun TweetDbEntity?.fromDbEntity() = this?.run {
            TweetViewEntity(
                id = id,
                text = text,
                authorId = authorId,
                username = username,
                name = name,
                profileImageUrl = profileImageUrl,
            )
        }
    }
}