package com.emreakcadag.data.response

import com.emreakcadag.data.base.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 02.03.2022
 */
data class MainResponse(
    @SerializedName("emre") val emre: String?
) : BaseResponse()