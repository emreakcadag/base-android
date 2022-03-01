package com.emreakcadag.baseandroid.main.ui

import android.util.Log
import com.emreakcadag.base.BaseViewModel
import com.emreakcadag.baseandroid.main.domain.GetMainDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 27.02.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMainDataUseCase: GetMainDataUseCase,
) : BaseViewModel() {

    override fun onInit() {
        getMainDataUseCase.invoke(Unit).withProgressBar().subscribe {
            Log.d("EMREEE", "ehueheuhue")
        }
    }
}