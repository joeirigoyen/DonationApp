package com.example.securityintegration.Models.User

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("status") var status : String,
    @SerializedName("message") var message : String
        )