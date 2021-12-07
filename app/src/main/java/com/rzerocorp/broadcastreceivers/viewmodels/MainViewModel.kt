package com.rzerocorp.broadcastreceivers.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val isNetworkAvailable: MutableLiveData<Boolean> = MutableLiveData()
}