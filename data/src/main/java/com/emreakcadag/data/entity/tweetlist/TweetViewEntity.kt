package com.emreakcadag.data.entity.tweetlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Parcelize
data class TweetViewEntity(
    val id: String?,
    val text: String?,
) : Parcelable