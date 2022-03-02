package com.emreakcadag.baseandroid.main.data

import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 01.03.2022
 */
class MainDataSource @Inject constructor(
    private val mainApiService: MainApiService,
) {

    suspend fun getMainData() = mainApiService.getMainData()
}