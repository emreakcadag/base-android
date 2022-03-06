package com.emreakcadag.baseandroid.main.data

import com.emreakcadag.data.network.BaseRepository
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
class MainRepository @Inject constructor(
    private val mainDataSource: MainDataSource
) : BaseRepository() {

    fun getMainData() = fetch {
        mainDataSource.getMainData()
    }
}