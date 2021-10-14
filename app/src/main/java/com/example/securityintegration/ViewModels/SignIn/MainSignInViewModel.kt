package com.example.securityintegration.ViewModels.SignIn

import androidx.lifecycle.ViewModel
import android.util.Patterns.EMAIL_ADDRESS
import java.sql.Date
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*
import kotlin.properties.Delegates

class MainSignInViewModel : ViewModel() {

    var userId : Int = 0
    lateinit var names : String
    lateinit var lastname_1 : String
    lateinit var lastname_2 : String
    lateinit var country : String
    lateinit var accType : String
    lateinit var birthDate : Date
    lateinit var email: String
    lateinit var password : String

    fun isValidEmail(email: String) : Boolean {
        return email != "" && EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidDate(date: String) : Boolean {
        val df = SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH)
        return try {
            df.parse(date)
            true
        } catch (e: ParseException) {
            false
        }
    }

    fun clear() {
        userId = 0
        names = ""
        lastname_1 = ""
        lastname_2 = ""
        country = ""
        accType = ""
        birthDate = Date(1, 1, 1)
        email = ""
        password = ""
    }
}