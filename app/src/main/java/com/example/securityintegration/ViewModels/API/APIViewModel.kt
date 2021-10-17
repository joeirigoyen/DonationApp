package com.example.securityintegration.ViewModels.API

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.APIService
import kotlinx.coroutines.launch
import retrofit2.Response

class APIViewModel(private val service: APIService) : ViewModel() {

    val myUserResponse : MutableLiveData<Response<User>> = MutableLiveData()
    val myEventsResponse : MutableLiveData<Response<List<Event>>> = MutableLiveData()

    fun getUser() {
        viewModelScope.launch {
            val response = service.getUser()
            myUserResponse.value = response
        }
    }

    fun getEvents() {
        viewModelScope.launch {
            val response = service.getEvents()
            myEventsResponse.value = response
        }
    }

}