package com.emreakcadag.domain.usecase.main

import com.emreakcadag.data.repository.MainRepository
import com.emreakcadag.data.response.MainResponse
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
class GetMainDataUseCase @Inject constructor(
    private val mainRepository: MainRepository,
) : BaseFlowUseCase<Unit?, MainResponse?>() {

    override fun onExecute(params: Unit?) = mainRepository.getMainData()
}