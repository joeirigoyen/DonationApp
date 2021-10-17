package com.example.securityintegration.Models.API

import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.User.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface APIInterface {
    @POST("usuario/ids")
    suspend fun getUser() : Response<User>

    @GET("usuario/verUsuarios")
    suspend fun getUsers() : Response<List<User>>

    @GET("evento/verEventos")
    suspend fun getEvents() : Response<List<Event>>
}