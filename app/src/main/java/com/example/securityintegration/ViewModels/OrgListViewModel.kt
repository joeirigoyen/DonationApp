package com.example.securityintegration.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService

class OrgListViewModel : ViewModel() {
    // Make a reference to Model
    private val model = OrgService()

    // Observable variables
    val orgList = MutableLiveData<List<Org>>()

    // Events
    fun getOrgs() {
        orgList.value = model.getOrgs()
    }
}