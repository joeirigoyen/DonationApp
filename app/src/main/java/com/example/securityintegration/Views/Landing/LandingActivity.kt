package com.example.securityintegration.Views.Landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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