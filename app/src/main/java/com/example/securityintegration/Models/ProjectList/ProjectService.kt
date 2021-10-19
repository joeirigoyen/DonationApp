package com.example.securityintegration.Models.ProjectList

import com.example.securityintegration.Models.User.Login.User

class ProjectService {

    var projects : ArrayList<Project> = arrayListOf()

    fun getProjects() : List<Project> {
        return projects
    }

    fun getProjects(user: User) : List<Project> {
        return projects
    }

}