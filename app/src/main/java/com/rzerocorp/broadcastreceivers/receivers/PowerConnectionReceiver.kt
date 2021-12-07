package com.rzerocorp.broadcastreceivers.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.util.Log

class PowerConnectionReceiver: BroadcastReceiver() {

    override fun onReceive(ctx: Context?, intent: Intent?) {
        Log.d(this::class.java.canonicalName,
            String.format("Battery status: %d", powerCheck(intent!!).toString()))
    }

    private fun powerCheck(intent: Intent): Int {
        return intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
    }
}