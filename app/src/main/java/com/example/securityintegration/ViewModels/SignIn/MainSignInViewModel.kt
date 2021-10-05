package com.example.securityintegration.ViewModels.SignIn

import androidx.lifecycle.ViewModel
import android.util.Patterns.EMAIL_ADDRESS
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainSignInViewModel : ViewModel() {

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

}