package com.example.securityintegration.Models.ProjectList

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.APIService

class ProjectService {

    var projects : ArrayList<Project> = arrayListOf()

    fun getProjects() : List<Project> {
        return projects
    }

    fun getProjects(user: User) : List<Project> {
        return projects
    }

}