package com.emreakcadag.base

import androidx.lifecycle.ViewModel

/**
 * Created by Emre Akçadağ on 27.02.2022
 */
abstract class BaseViewModel : ViewModel() {

    abstract fun onInit()
}