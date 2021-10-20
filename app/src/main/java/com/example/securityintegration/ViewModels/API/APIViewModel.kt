package com.example.securityintegration.ViewModels.API

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.EventList.EventCreator
import com.example.securityintegration.Models.EventList.UserEventRequest
import com.example.securityintegration.Models.ProjectList.ProjectRequest
import com.example.securityintegration.Models.User.*
import com.example.securityintegration.Models.User.Donation.Donation
import com.example.securityintegration.Models.User.Donation.DonationCreator
import com.example.securityintegration.Models.User.Donation.DonationInput
import com.example.securityintegration.Models.User.Login.*
import com.example.securityintegration.Models.User.Login.UserResponse
import com.example.securityintegration.Models.User.Recovery.RecoveryRequest
import com.example.securityintegration.Models.User.Recovery.RecoveryResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class APIViewModel(private val service: APIService) : ViewModel() {

    val myUserResponse : MutableLiveData<Response<SignUpResponse>> = MutableLiveData()
    val myEventsResponse : MutableLiveData<Response<List<Event>>> = MutableLiveData()
    val myProjectResponse : MutableLiveData<Response<Project>> = MutableLiveData()
    val myProjectsResponse : MutableLiveData<Response<List<Project>>> = MutableLiveData()
    val orgsResponse : MutableLiveData<Response<List<User>>> = MutableLiveData()
    val donationsResponse : MutableLiveData<Response<List<Donation>>> = MutableLiveData()
    val donationResponse : MutableLiveData<Response<Donation>> = MutableLiveData()
    val eventResponse : MutableLiveData<Response<Event>> = MutableLiveData()
    val userExistsResponse : MutableLiveData<Response<UserExistsResponse>> = MutableLiveData()
    val questionResponse : MutableLiveData<Response<QuestionResponse>> = MutableLiveData()
    val validateQuestionResponse : MutableLiveData<Response<ValidateQuestionResponse>> = MutableLiveData()
    val newPasswordResponse : MutableLiveData<Response<NewPasswordResponse>> = MutableLiveData()
    val eventFromResponse : MutableLiveData<Response<List<Event>>> = MutableLiveData()
    val projectFromResponse : MutableLiveData<Response<List<Project>>> = MutableLiveData()
    val usernameResponse : MutableLiveData<Response<UserExistsResponse>> = MutableLiveData()
    val validDateResponse : MutableLiveData<Response<SignUpResponse>> = MutableLiveData()

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

    fun postGetDonations(user: DonationInput) {
        viewModelScope.launch {
            val response = service.postGetDonations(user)
            donationsResponse.value = response
        }
    }

    fun postDonation(donation: DonationCreator) {
        viewModelScope.launch {
            val response = service.postDonation(donation)
            donationResponse.value = response
        }
    }

    fun postEvent(event: EventCreator) {
        viewModelScope.launch {
            val response = service.postEvent(event)
            eventResponse.value = response
        }
    }

    fun postUserExists(user: UserExistsRequest) {
        viewModelScope.launch {
            val response = service.postUserExists(user)
            userExistsResponse.value = response
        }
    }

    fun postGetQuestion(request: QuestionRequest) {
        viewModelScope.launch {
            val response = service.postGetQuestion(request)
            questionResponse.value = response
        }
    }

    fun postValidateQuestion(request: ValidateQuestionRequest) {
        viewModelScope.launch {
            val response = service.postValidateQuestion(request)
            validateQuestionResponse.value = response
        }
    }

    fun putNewPassword(request: NewPasswordRequest) {
        viewModelScope.launch {
            val response = service.putNewPassword(request)
            newPasswordResponse.value = response
            Log.e("diego", response.toString())
        }
    }

    fun getEventsFrom(user: UserEventRequest) {
        viewModelScope.launch {
            val response = service.getEventsFrom(user)
            eventFromResponse.value = response
        }
    }

    fun getProjectsFrom(user: UserEventRequest) {
        viewModelScope.launch {
            val response = service.getProjectsFrom(user)
            projectFromResponse.value = response
        }
    }

    fun postProject(project: ProjectRequest) {
        viewModelScope.launch {
            val response = service.postProject(project)
            myProjectResponse.value = response
        }
    }

    fun getUsernameExists(user: UsernameRequest) {
        viewModelScope.launch {
            val response = service.getUsernameExists(user)
            usernameResponse.value = response
        }
    }

    fun isValidDate(fecha_nacimiento: ValidDateRequest) {
        viewModelScope.launch {
            val response = service.isValidDate(fecha_nacimiento)
            validDateResponse.value = response
        }
    }

}