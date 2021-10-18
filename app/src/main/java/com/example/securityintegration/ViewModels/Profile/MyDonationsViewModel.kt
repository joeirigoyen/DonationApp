package com.example.securityintegration.ViewModels.Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.User.Donation
import com.example.securityintegration.Models.User.DonationInput
import com.example.securityintegration.Models.User.DonationService
import com.example.securityintegration.Models.User.User

class MyDonationsViewModel : ViewModel() {

    private val model = DonationService()
    val donationList = MutableLiveData<List<Donation>>()

}