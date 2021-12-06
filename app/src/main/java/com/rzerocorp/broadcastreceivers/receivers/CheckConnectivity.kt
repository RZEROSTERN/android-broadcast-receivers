package com.rzerocorp.broadcastreceivers.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log


class CheckConnectivity: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(this::class.java.canonicalName,
            String.format("Connection status: %b", isOnline(context).toString()))
    }

    private fun isOnline(context: Context?): Boolean {
        val cm = context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.state == NetworkInfo.State.CONNECTED
    }
}