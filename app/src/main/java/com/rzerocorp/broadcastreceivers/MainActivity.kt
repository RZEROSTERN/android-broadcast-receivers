package com.rzerocorp.broadcastreceivers

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.rzerocorp.broadcastreceivers.databinding.ActivityMainBinding
import com.rzerocorp.broadcastreceivers.receivers.CheckConnectivity
import android.net.ConnectivityManager

import android.content.IntentFilter

import android.os.Build
import android.widget.Toast
import androidx.activity.viewModels
import com.rzerocorp.broadcastreceivers.viewmodels.ConnectionLiveData
import com.rzerocorp.broadcastreceivers.viewmodels.MainViewModel
import com.rzerocorp.broadcastreceivers.viewmodels.isConnected


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    protected lateinit var connectionLiveData: ConnectionLiveData
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        connectionLiveData = ConnectionLiveData(this)

        connectionLiveData.observe(this) {
            viewModel.isNetworkAvailable.postValue(it)
        }

        viewModel.isNetworkAvailable.observe(this, {
            when(it) {
                false -> Toast.makeText(this, "Hey! Give me some Internet, please !!!!",
                        Toast.LENGTH_LONG).show()
                true -> Toast.makeText(this, "Thank you for the Internet!",
                    Toast.LENGTH_LONG).show()
            }
        })

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}