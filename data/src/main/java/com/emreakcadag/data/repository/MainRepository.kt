package com.emreakcadag.data.repository

import com.emreakcadag.data.base.BaseRepository
import com.emreakcadag.data.datasource.MainDataSource
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