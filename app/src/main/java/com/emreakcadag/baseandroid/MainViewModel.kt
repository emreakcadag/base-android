package com.emreakcadag.baseandroid

import com.emreakcadag.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Emre Akçadağ on 27.02.2022
 */
@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    override fun onInit() {}
}