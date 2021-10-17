package com.example.securityintegration.Models.User

import com.example.securityintegration.Models.API.RetrofitInstance
import com.example.securityintegration.Models.EventList.Event
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

}