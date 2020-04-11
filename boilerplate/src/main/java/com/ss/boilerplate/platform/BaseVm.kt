package com.ss.boilerplate.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseVm<NavState : BaseVm.NavState> : ViewModel() {
    val navState by lazy { MutableLiveData<NavState>() }

    interface NavState
}