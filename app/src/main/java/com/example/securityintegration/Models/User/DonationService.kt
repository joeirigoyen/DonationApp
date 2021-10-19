package com.example.securityintegration.Models.User

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import java.math.BigDecimal
import java.sql.Date

class DonationService {

    val donations : ArrayList<Donation> = arrayListOf()

    fun getDonations(username: String): List<Donation> {
        return donations
    }

}