package com.example.securityintegration.ViewModels.Profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.ProjectList.ProjectService
import com.example.securityintegration.Models.User.User

class MyProjectsViewModel : ViewModel() {

    private val model = ProjectService()
    val projectList = MutableLiveData<List<Project>>()

    fun getProjects() {
        projectList.value = model.getProjects()
    }

    fun getProjects(user: User) {
        projectList.value = model.getProjects(user)
    }

}