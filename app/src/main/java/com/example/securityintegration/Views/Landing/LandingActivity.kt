package com.example.securityintegration.Views.Landing

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Landing.LandingViewModel

class LandingActivity : AppCompatActivity() {

    private val viewModel : LandingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)
    }
}