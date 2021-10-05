package com.example.securityintegration.ViewModels.SignUp

import android.content.Intent
import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainSignUpViewModel : ViewModel() {

    private var names : String = ""
    private var firstLastName : String = ""
    private var secondLastName : String = ""
    private var username : String = ""
    private var birthDate : String = ""
    private var accountBtnId: String = ""
    private var membershipBtnId: String = ""

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

    fun isValidDate(date: String) : Boolean {
        val df = SimpleDateFormat("dd-MM-yyyy", Locale.FRENCH)
        return try {
            df.parse(date)
            true
        } catch (e: ParseException) {
            false
        }
    }

    fun setGeneralInfo(infoType: String, info: String) {
        when (infoType) {
            "name" -> names = info
            "firstLastName" -> firstLastName = info
            "secondLastName" -> secondLastName = info
            "username" -> username = info
            "birthDate" -> birthDate = info
        }
    }

    fun getGeneralInfo(infoType: String) : String {
        return when (infoType) {
            "name" -> names
            "firstLastName" -> firstLastName
            "secondLastName" -> secondLastName
            "username" -> username
            "birthDate" -> birthDate
            else -> ""
        }
    }
}