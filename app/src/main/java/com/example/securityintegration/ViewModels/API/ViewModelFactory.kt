package com.example.securityintegration.ViewModels.API

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.securityintegration.Models.API.APIService

class ViewModelFactory(private val service: APIService) : ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>) : T {
        return APIViewModel(service) as T
    }
}