package com.emreakcadag.baseandroid.main.domain

import com.emreakcadag.baseandroid.main.data.MainRepository
import com.emreakcadag.baseandroid.main.data.MainResponse
import com.emreakcadag.network.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
class GetMainDataUseCase @Inject constructor(
    private val mainRepository: MainRepository,
) : BaseFlowUseCase<Unit?, MainResponse?>() {

    override fun onExecute(param: Unit?) = mainRepository.getMainData()
}