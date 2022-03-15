package com.emreakcadag.domain.usecase.common

import androidx.datastore.preferences.core.Preferences
import com.emreakcadag.data.repository.datastore.DataStoreRepository
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class DataStoreSetValueUseCase<T> @Inject constructor(
    private val dataStoreRepository: DataStoreRepository,
) : BaseFlowUseCase<DataStoreSetValueUseCase.Params<T>, Any?>() {

    override fun onExecute(params: Params<T>?) = dataStoreRepository.setValue(params?.key, params?.value)

    data class Params<T>(val key: Preferences.Key<T>?, val value: T?)
}