package com.example.securityintegration.Models.OrgLookup

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import java.util.*

data class Org (val name : String, val desc : String, val creationDate: Date, val nativeCountry: String) : Serializable