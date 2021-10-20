package com.example.securityintegration.Models.API

import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.EventList.EventCreator
import com.example.securityintegration.Models.EventList.UserEventRequest
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.ProjectList.ProjectRequest
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
import retrofit2.Call
import retrofit2.Response

class APIService {

    suspend fun getUser() : Response<User> {
        return RetrofitInstance.api.getUser()
    }

    suspend fun getUsers() : Response<List<User>> {
        return RetrofitInstance.api.getUsers()
    }

    suspend fun getEvents() : Response<List<Event>> {
        return RetrofitInstance.api.getEvents()
    }

    suspend fun getProjects(): Response<List<Project>> {
        return RetrofitInstance.api.getProjects()
    }

    suspend fun getOrgs(): Response<List<User>> {
        return RetrofitInstance.api.getOrgs()
    }

    suspend fun postGetDonations(user: DonationInput) : Response<List<Donation>> {
        return RetrofitInstance.api.getDonations(user)
    }

    suspend fun postUser(user: UserResponse) : Response<UserResponse> {
        return RetrofitInstance.api.postUser(user)
    }

    suspend fun postProject(project: ProjectRequest) : Response<Project> {
        return RetrofitInstance.api.postProject(project)
    }

    fun postLogin(login: LoginInputResponse): Call<LoginResponse> {
        return RetrofitInstance.api.postLogin(login)
    }

    suspend fun postDonation(donation: DonationCreator) : Response<Donation> {
        return RetrofitInstance.api.postDonation(donation)
    }

    suspend fun postEvent(event: EventCreator) : Response<Event> {
        return RetrofitInstance.api.postEvent(event)
    }

    suspend fun validateRecovery(request: RecoveryRequest) : Response<RecoveryResponse> {
        return RetrofitInstance.api.validateRecovery(request)
    }

    suspend fun postUserExists(user: UserExistsRequest): Response<UserExistsResponse> {
        return RetrofitInstance.api.postUserExists(user)
    }

    suspend fun postGetQuestion(request: QuestionRequest) : Response<QuestionResponse> {
        return RetrofitInstance.api.postGetQuestion(request)
    }

    suspend fun postValidateQuestion(request: ValidateQuestionRequest): Response<ValidateQuestionResponse> {
        return RetrofitInstance.api.postValidateQuestion(request)
    }

    suspend fun putNewPassword(request: NewPasswordRequest) : Response<NewPasswordResponse> {
        return RetrofitInstance.api.putNewPassword(request)
    }

    suspend fun getEventsFrom(user: UserEventRequest) : Response<List<Event>> {
        return RetrofitInstance.api.getEventsFrom(user)
    }

    suspend fun getProjectsFrom(user: UserEventRequest): Response<List<Project>> {
        return RetrofitInstance.api.getProjectsFrom(user)
    }

    suspend fun getUsernameExists(user: UsernameRequest) : Response<UserExistsResponse> {
        return RetrofitInstance.api.getUsernameExists(user)
    }

}