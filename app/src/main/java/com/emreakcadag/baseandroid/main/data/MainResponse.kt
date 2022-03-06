package com.emreakcadag.baseandroid.main.data

import com.emreakcadag.data.network.BaseResponse
import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 02.03.2022
 */
data class MainResponse(
    @SerializedName("emre") val emre: String?
) : BaseResponse()
