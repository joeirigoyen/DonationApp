package com.example.securityintegration.ViewModels.Projects

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.ProjectList.ProjectService

class ProjectListViewModel : ViewModel() {
    private val model = ProjectService()
    val eventList = MutableLiveData<List<Project>>()

    fun getProjects() {
        eventList.value = model.getProjects()
    }

}