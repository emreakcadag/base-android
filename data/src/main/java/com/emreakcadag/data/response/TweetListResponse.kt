package com.emreakcadag.data.response

import com.emreakcadag.data.base.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
data class TweetListResponse(
    @SerializedName("data") val tweetList: List<TweetModel>?,
    @SerializedName("includes") val tweetIncludes: TweetIncludes?,
    @SerializedName("meta") val tweetMetaModel: TweetMetaModel?,
) : BaseResponse()

data class TweetModel(
    @SerializedName("id") val id: String?,
    @SerializedName("author_id") val authorId: String?,
    @SerializedName("text") val text: String?,
)

data class TweetMetaModel(
    @SerializedName("next_token") val nextToken: String?,
)

data class TweetIncludes(
    @SerializedName("users") val users: List<UserResponse>?,
)

data class UserResponse(
    @SerializedName("id") val id: String?,
    @SerializedName("profile_image_url") val profileImageUrl: String?,
    @SerializedName("username") val username: String?,
    @SerializedName("name") val name: String?,
)