package com.emreakcadag.domain.usecase.common

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.common.ApiResult
import com.emreakcadag.data.repository.DataStoreRepository
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class DataStoreGetValueUseCase<T> @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
) : BaseFlowUseCase<Preferences.Key<T>, T?>() {

    override fun onExecute(params: Preferences.Key<T>?): Flow<ApiResult<T?>> = dataStoreRepository.getValue(params)
}