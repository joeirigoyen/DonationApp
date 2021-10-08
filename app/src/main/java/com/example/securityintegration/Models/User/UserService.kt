package com.example.securityintegration.Models.User

import java.sql.Date

class UserService {

    var userList : ArrayList<User> = arrayListOf(
        User(1, "Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
        User(2, "Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
        User(3, "Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
    )

    fun getUsers() : List<User> {
        return userList
    }

}