package com.example.securityintegration.Models.ProjectList

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.User.User
import java.io.Serializable

class Project (val name: String, val desc: String, val org: Org, val participants: List<User>) : Serializable