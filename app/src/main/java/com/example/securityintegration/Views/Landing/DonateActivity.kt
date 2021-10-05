package com.example.securityintegration.Views.Landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.securityintegration.databinding.ActivityDonateBinding

class DonateActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDonateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDonateBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}