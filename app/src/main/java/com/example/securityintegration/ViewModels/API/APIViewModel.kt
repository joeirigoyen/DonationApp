package com.example.securityintegration.ViewModels.API

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.LoginInputResponse
import com.example.securityintegration.Models.User.LoginResponse
import com.example.securityintegration.Models.User.UserResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class APIViewModel(private val service: APIService) : ViewModel() {

    val myUserResponse : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    val myEventsResponse : MutableLiveData<Response<List<Event>>> = MutableLiveData()
    val myProjectResponse : MutableLiveData<Response<Project>> = MutableLiveData()
    val myProjectsResponse : MutableLiveData<Response<List<Project>>> = MutableLiveData()
    val orgsResponse : MutableLiveData<Response<List<User>>> = MutableLiveData()
    val loginResponse : MutableLiveData<Response<LoginResponse>> = MutableLiveData()

    fun getEvents() {
        viewModelScope.launch {
            val response = service.getEvents()
            myEventsResponse.value = response
        }
    }

    fun getProjects() {
        viewModelScope.launch {
            val response = service.getProjects()
            myProjectsResponse.value = response
        }
    }

    fun getOrgs() {
        viewModelScope.launch {
            val response = service.getOrgs()
            orgsResponse.value = response
        }
    }

    fun postUser(user: UserResponse) {
        viewModelScope.launch {
            try {
                val response = service.postUser(user)
                myUserResponse.value = response
            } catch (e: com.google.gson.stream.MalformedJsonException) {
                Log.e("CUSTOM ERROR", "Found error at viewModel")
            }
        }
    }

    fun postProject(projId: Int, projName: String, projDesc: String, projOrg: String) {
        viewModelScope.launch {
            val response = service.postProject(projId, projName, projDesc, projOrg)
            myProjectResponse.value = response
        }
    }

    fun postLogin(login: LoginInputResponse) {
        viewModelScope.launch {
            service.postLogin(login)
        }
    }

}