package com.emreakcadag.data.response

import com.emreakcadag.data.base.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
data class TweetListResponse(
    @SerializedName("data") val tweetList: List<TweetModel>?,
    @SerializedName("meta") val tweetMetaModel: TweetMetaModel?
) : BaseResponse()

data class TweetModel(
    @SerializedName("id") val id: String?,
    @SerializedName("text") val text: String?,
)

data class TweetMetaModel(
    @SerializedName("next_token") val nextToken: String?,
)