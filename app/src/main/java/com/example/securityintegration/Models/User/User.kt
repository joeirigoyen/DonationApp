package com.example.securityintegration.Models.User

import com.paypal.pyplcheckout.addshipping.model.Country
import java.sql.Date

data class User (val names: String, val firstLastName: String, val secondLastName: String, val country: String, val accType: String, val birthDate: String, val email: String, val password: String, val securityQuestion: String, val securityAnswer: String)