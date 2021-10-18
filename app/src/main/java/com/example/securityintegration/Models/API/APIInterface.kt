package com.example.securityintegration.Models.API

import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.User.LoginInputResponse
import com.example.securityintegration.Models.User.LoginResponse
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.UserResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface APIInterface {
    @POST("usuario/ids")
    suspend fun getUser() : Response<User>

    @Headers("Accept: application/json")
    @POST("usuario/agregarUsuario")
    suspend fun postUser(@Body user: UserResponse) : Response<UserResponse>

    @Headers("Content-Type: application/json")
    @FormUrlEncoded
    @POST("proyecto/agregarProyecto")
    suspend fun postProject(
        @Field("id_proyecto") projId : Int,
        @Field("nombre") projName : String,
        @Field("descripcion") projDesc : String,
        @Field("org_creadora") projOrg : String
    ) : Response<Project>

    @GET("usuario/verUsuarios")
    suspend fun getUsers() : Response<List<User>>

    @GET("evento/verEventos")
    suspend fun getEvents() : Response<List<Event>>

    @GET("proyecto/verProyectos")
    suspend fun getProjects() : Response<List<Project>>

    @GET("usuario/orgs")
    suspend fun getOrgs() : Response<List<User>>

    @Headers("Content-Type: application/json")
    @POST("usuario/loginUsuario")
    fun postLogin(@Body user: LoginInputResponse) : Call<LoginResponse>
}