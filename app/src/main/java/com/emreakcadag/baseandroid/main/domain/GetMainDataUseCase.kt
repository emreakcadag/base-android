package com.emreakcadag.baseandroid.main.domain

import com.emreakcadag.baseandroid.main.data.MainRepository
import com.emreakcadag.network.ApiResult
import com.emreakcadag.network.BaseFlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 28.02.2022
 */
class GetMainDataUseCase @Inject constructor(
    private val mainRepository: MainRepository,
) : BaseFlowUseCase<Unit, String?>() {

    override fun execute(params: Unit): Flow<ApiResult<String?>> = mainRepository.getMainData()
}