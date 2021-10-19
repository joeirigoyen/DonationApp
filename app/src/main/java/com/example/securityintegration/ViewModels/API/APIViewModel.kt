package com.example.securityintegration.ViewModels.API

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.EventList.EventCreator
import com.example.securityintegration.Models.User.*
import com.example.securityintegration.Models.User.Donation.Donation
import com.example.securityintegration.Models.User.Donation.DonationCreator
import com.example.securityintegration.Models.User.Donation.DonationInput
import com.example.securityintegration.Models.User.Login.LoginInputResponse
import com.example.securityintegration.Models.User.Login.LoginResponse
import com.example.securityintegration.Models.User.Login.User
import com.example.securityintegration.Models.User.Login.UserResponse
import com.example.securityintegration.Models.User.Recovery.RecoveryRequest
import com.example.securityintegration.Models.User.Recovery.RecoveryResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class APIViewModel(private val service: APIService) : ViewModel() {

    val myUserResponse : MutableLiveData<Response<UserResponse>> = MutableLiveData()
    val myEventsResponse : MutableLiveData<Response<List<Event>>> = MutableLiveData()
    val myProjectResponse : MutableLiveData<Response<Project>> = MutableLiveData()
    val myProjectsResponse : MutableLiveData<Response<List<Project>>> = MutableLiveData()
    val orgsResponse : MutableLiveData<Response<List<User>>> = MutableLiveData()
    val loginResponse : MutableLiveData<Response<LoginResponse>> = MutableLiveData()
    val donationsResponse : MutableLiveData<Response<List<Donation>>> = MutableLiveData()
    val donationResponse : MutableLiveData<Response<Donation>> = MutableLiveData()
    val eventResponse : MutableLiveData<Response<Event>> = MutableLiveData()
    val recoveryResponse : MutableLiveData<Response<RecoveryResponse>> = MutableLiveData()
    val userExistsResponse : MutableLiveData<Response<UserExistsResponse>> = MutableLiveData()
    val questionResponse : MutableLiveData<Response<QuestionResponse>> = MutableLiveData()
    val validateQuestionResponse : MutableLiveData<Response<ValidateQuestionResponse>> = MutableLiveData()
    val newPasswordResponse : MutableLiveData<Response<NewPasswordResponse>> = MutableLiveData()

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

    fun validateRecovery(request: RecoveryRequest) {
        viewModelScope.launch {
            val response = service.validateRecovery(request)
            recoveryResponse.value = response
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