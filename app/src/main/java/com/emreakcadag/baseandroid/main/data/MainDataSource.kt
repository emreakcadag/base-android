package com.emreakcadag.baseandroid.main.data

import com.emreakcadag.network.ApiService
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
class MainDataSource @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getMainData() = apiService.getMainData()
}