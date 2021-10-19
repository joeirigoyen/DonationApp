package com.example.securityintegration.Models.API

import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.User.*
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

    suspend fun postProject(projId: Int, projName: String, projDesc: String, projOrg: String) : Response<Project> {
        return RetrofitInstance.api.postProject(projId, projName, projDesc, projOrg)
    }

    fun postLogin(login: LoginInputResponse): Call<LoginResponse> {
        return RetrofitInstance.api.postLogin(login)
    }

    suspend fun postDonation(donation: DonationCreator) : Response<Donation> {
        return RetrofitInstance.api.postDonation(donation)
    }

}