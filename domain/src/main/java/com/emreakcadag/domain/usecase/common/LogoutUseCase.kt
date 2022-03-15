package com.emreakcadag.domain.usecase.common

import com.emreakcadag.common.Constant.BLANK
import com.emreakcadag.data.datastore.BaseDataStore
import com.emreakcadag.domain.usecase.base.BaseFlowUseCase
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 13.03.2022
 */
class LogoutUseCase @Inject constructor(
    private val dataStoreSetValueUseCase: DataStoreSetValueUseCase<String>,
) : BaseFlowUseCase<Unit?, Any?>() {

    override fun onExecute(params: Unit?) = dataStoreSetValueUseCase.execute(DataStoreSetValueUseCase.Params(BaseDataStore.PreferenceKey.token, BLANK))
}