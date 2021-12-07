package com.rzerocorp.broadcastreceivers.viewmodels

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.BatteryManager
import android.util.Log
import androidx.lifecycle.LiveData

class PowerCheckLiveData(private val context: Context): LiveData<Int>() {
    private val powerCheckReceiver = object: BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val level: Int = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            postValue(level)
        }
    }

    override fun onActive() {
        super.onActive()
        context.registerReceiver(
            powerCheckReceiver,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )
    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(powerCheckReceiver)
    }
}

// val Context.power: Int get() = -1