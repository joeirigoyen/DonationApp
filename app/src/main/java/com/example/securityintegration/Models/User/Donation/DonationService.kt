package com.example.securityintegration.Models.User.Donation

class DonationService {

    val donations : ArrayList<Donation> = arrayListOf()

    fun getDonations(username: String): List<Donation> {
        return donations
    }

}