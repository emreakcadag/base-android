package com.emreakcadag.base.firebase.remoteconfig

/**
 * Created by Emre Akçadağ on 14.03.2022
 */
enum class RemoteConfigParameter(val key: String) {

    BASE_URL("baseUrl"),
    USERNAME("username"),
    PASSWORD("password"),
    TOOLBAR_IMAGE_URL("toolbarImageUrl"),
    TOOLBAR_TITLE("toolbarTitle"),
}