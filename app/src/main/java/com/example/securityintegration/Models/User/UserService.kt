package com.example.securityintegration.Models.User

import android.app.DownloadManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import java.sql.Date

class UserService {

    private var userList : ArrayList<User> = arrayListOf(
        User("Youthan", "Irigoyen", "Usuario", "México", "Inversionista", "18/06/2000", "youthan@gmail.com", "hello", "¿Cuál es el nombre de tu primer mascota?", "Bolo"),
        User("Eduardo", "Irigoyen", "Usuario", "México", "Inversionista", "01/02/1999", "eduardo@gmail.com", "hello", "¿Cuál es el nombre de tu primer mascota?", "Edu"),
        User("Jared", "Irigoyen", "Usuario", "México", "Inversionista", "01/02/2003", "jared@gmail.com", "hello", "¿Cuál es el nombre de tu primer mascota?", "Jared")
    )

    fun getUsers() : List<User> {
        return userList
    }

    fun testFun() {

    }

}