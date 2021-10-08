package com.example.securityintegration.Models.User

import java.sql.Date

class UserService {

    var userList : ArrayList<User> = arrayListOf(
        User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
        User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
        User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
    )

    fun getUsers() : List<User> {
        return userList
    }

}