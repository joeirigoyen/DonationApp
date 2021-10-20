/*
* Autor: Raúl Youthan Irigoyen Osorio
* */

package com.example.securityintegration.Models.API

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val gson : Gson = GsonBuilder().setLenient().create()
    private val client = OkHttpClient()


    private val retrofit by lazy {
        Retrofit.Builder()
            .client(client)
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: APIInterface by lazy {
        retrofit.create(APIInterface::class.java)
    }

}