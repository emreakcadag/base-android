package com.emreakcadag.network

import com.google.gson.annotations.SerializedName

/**
 * Created by Emre Akçadağ on 02.03.2022
 */
open class BaseResponse {

    @SerializedName("dialogBox")
    var dialogBox: String? = null // todo emreakcadag impl DialogBoxModel later.
}