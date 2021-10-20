package com.example.securityintegration.Models.API

import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.EventList.EventCreator
import com.example.securityintegration.Models.EventList.UserEventRequest
import com.example.securityintegration.Models.ProjectList.Project
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

    @Headers("Content-Type: application/json")
    @POST("donacion/verDonaciones")
    suspend fun getDonations(@Body user: DonationInput) : Response<List<Donation>>

    @Headers("Content-Type: application/json")
    @POST("donacion/agregarDonacion")
    suspend fun postDonation(@Body donation: DonationCreator) : Response<Donation>

    @Headers("Content-Type: application/json")
    @POST("evento/agregarEvento")
    suspend fun postEvent(@Body event: EventCreator) : Response<Event>

    @Headers("Content-Type: application/json")
    @POST("usuario/cambiarPassword")
    suspend fun validateRecovery(@Body rec_request: RecoveryRequest) : Response<RecoveryResponse>

    @Headers("Content-Type: application/json")
    @POST("usuario/buscarUsuario")
    suspend fun postUserExists(@Body user: UserExistsRequest): Response<UserExistsResponse>

    @Headers("Content-Type: application/json")
    @POST("usuario/buscarPregunta")
    suspend fun postGetQuestion(@Body request: QuestionRequest): Response<QuestionResponse>

    @Headers("Content-Type: application/json")
    @POST("usuario/cambiarPassword")
    suspend fun postValidateQuestion(@Body request: ValidateQuestionRequest): Response<ValidateQuestionResponse>

    @Headers("Content-Type: application/json")
    @PUT("usuario/cambiarPassword")
    suspend fun putNewPassword(@Body request: NewPasswordRequest) : Response<NewPasswordResponse>

    @Headers("Content-Type: application/json")
    @PUT("evento/verEventosPorOrg")
    suspend fun getEventsFrom(@Body user: UserEventRequest) : Response<List<Event>>

    @Headers("Content-Type: application/json")
    @PUT("proyecto/verProyectos")
    suspend fun getProjectsFrom(@Body user: UserEventRequest) : Response<List<Project>>
}