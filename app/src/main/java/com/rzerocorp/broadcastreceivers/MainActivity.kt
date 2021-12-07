package com.rzerocorp.broadcastreceivers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rzerocorp.broadcastreceivers.databinding.ActivityMainBinding

import android.widget.Toast
import com.rzerocorp.broadcastreceivers.viewmodels.ConnectionLiveData


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}