package com.emreakcadag.data.viewentity.tweetdetail

import android.os.Parcelable
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
) : Parcelable