package com.emreakcadag.base.firebase.remoteconfig

/**
 * Created by Emre Akçadağ on 08.03.2022
 */
interface RemoteConfig {

    fun initialize(onInitializeSuccess: ((Boolean) -> Unit)? = null)

    fun getString(key: String?): String

    fun getString(key: RemoteConfigParameter?): String

    fun getInt(key: String?): Long?

    fun getDouble(key: String?): Double?

    fun getBoolean(key: String?): Boolean?
}