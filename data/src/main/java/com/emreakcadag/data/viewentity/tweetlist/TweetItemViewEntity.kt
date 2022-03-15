package com.emreakcadag.data.viewentity.tweetlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Parcelize
data class TweetItemViewEntity(
    val id: String?,
    val text: String?,
    val authorId: String?,
    val username: String?,
    val name: String?,
    val profileImageUrl: String?,
) : Parcelable