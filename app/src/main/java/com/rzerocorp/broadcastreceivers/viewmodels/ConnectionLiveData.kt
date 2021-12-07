package com.rzerocorp.broadcastreceivers.viewmodels

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData

class ConnectionLiveData(private val context: Context): LiveData<Boolean>()  {
    private val networkReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Log.d(this::class.java.canonicalName,
                String.format("Connection status: %b", context.isConnected))
            postValue(context.isConnected)
        }
    }

    override fun onActive() {
        super.onActive()
        context.registerReceiver(
            networkReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    override fun onInactive() {
        super.onInactive()
        context.unregisterReceiver(networkReceiver)
    }
}

val Context.isConnected: Boolean get() =
    (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)?.
        activeNetworkInfo?.isConnected == true