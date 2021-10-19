package com.example.securityintegration.ViewModels.Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.User.Donation.Donation
import com.example.securityintegration.Models.User.Donation.DonationService

class MyDonationsViewModel : ViewModel() {

    private val model = DonationService()
    val donationList = MutableLiveData<List<Donation>>()

}