package com.emreakcadag.base.firebase.remoteconfig

import com.emreakcadag.common.Constant.BLANK
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings

/**
 * Created by Emre Akçadağ on 08.03.2022
 */
class RemoteConfigImpl : RemoteConfig {

    private val instance by lazy { Firebase.remoteConfig }

    override
    fun initialize(onInitializeSuccess: ((Boolean) -> Unit)?) {
        instance.setConfigSettingsAsync(remoteConfigSettings { minimumFetchIntervalInSeconds = 1 })

        instance.fetchAndActivate().addOnSuccessListener {
            onInitializeSuccess?.invoke(true)
        }.addOnFailureListener {
            onInitializeSuccess?.invoke(false)
        }.addOnCanceledListener {
            onInitializeSuccess?.invoke(false)
        }
    }

    override
    fun getString(key: String?): String = key?.run {
        instance.getString(this)
    } ?: BLANK

    override
    fun getString(key: RemoteConfigParameter?): String = key?.run {
        instance.getString(this.key)
    } ?: BLANK

    override
    fun getInt(key: String?): Long? = key?.run {
        instance.getLong(this)
    }

    override
    fun getDouble(key: String?): Double? = key?.run {
        instance.getDouble(this)
    }

    override
    fun getBoolean(key: String?): Boolean? = key?.run {
        instance.getBoolean(this)
    }
}