package com.example.securityintegration.Models.OrgLookup

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Org (val name : String, val desc : String) : Parcelable