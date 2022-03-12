package com.emreakcadag.data.response

import com.emreakcadag.data.base.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
data class LoginResponse(
    @SerializedName("token_type") val tokenType: String?,
    @SerializedName("access_token") val accessToken: String?
) : BaseResponse()