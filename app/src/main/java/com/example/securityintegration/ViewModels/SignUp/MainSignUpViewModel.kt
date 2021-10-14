package com.example.securityintegration.ViewModels.SignUp

import android.content.Intent
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.sql.Date
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainSignUpViewModel : ViewModel() {

    var userId : Int = 0
    var names : String = ""
    var firstLastName : String = ""
    var secondLastName : String = ""
    var username : String = ""
    var accType : String = ""
    var birthDate : String = ""
    var accountBtnId: String = ""
    var membershipBtnId: String = ""
    var country: String = ""
    var email: String = ""
    var password : String = ""
    var secQuestion : String = ""
    var secAnswer : String = ""

    fun setSelectedBtnId(btnId : String, btn : String) {
        when (btn) {
            "account" -> accountBtnId = btnId
            "membership" -> membershipBtnId = btnId
        }
    }

    fun getSelectedBtnId(btn: String) : String {
        return when(btn) {
            "account" -> accountBtnId
            "membership" -> membershipBtnId
            else -> ""
        }
    }

    fun isValidEmail(email: String) : Boolean {
        return email != "" && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}