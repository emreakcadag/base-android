package com.emreakcadag.data.response

import com.emreakcadag.data.base.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
data class TweetDetailResponse(
    @SerializedName("data") val tweet: TweetModel?,
    @SerializedName("includes") val tweetIncludes: TweetIncludes?,
) : BaseResponse()
