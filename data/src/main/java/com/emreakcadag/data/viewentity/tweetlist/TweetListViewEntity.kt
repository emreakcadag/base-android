package com.emreakcadag.data.viewentity.tweetlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
@Parcelize
data class TweetListViewEntity(
    val tweetItemList: List<TweetItemViewEntity>?,
    val nextToken: String?,
) : Parcelable