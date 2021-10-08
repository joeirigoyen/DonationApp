package com.example.securityintegration.Models.User

import java.sql.Date

class User (val userId: Int, val name: String, val firstLastName: String, val secondLastName: String, val birthdate: Date, val email: String, val password: String)