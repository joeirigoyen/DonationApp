package com.example.securityintegration.Models.ProjectList

import android.widget.Toast
import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.UserService
import java.sql.Date
import kotlin.coroutines.coroutineContext

class ProjectService {

    var orgs : List<Org> = OrgService().getOrgs()
    var users : List<User> = UserService().getUsers()
    var projects : ArrayList<Project> = arrayListOf(
        Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto D", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto E", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto D", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto E", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto D", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        )),
        Project("Proyecto E", "Lorem dona", orgs[0], listOf(
            users[0], users[1], users[2]
        ))
    )

    fun getProjects() : List<Project> {
        return projects
    }

    fun getProjects(user: User) : List<Project> {
        println("${users[0]} != $user")
        return projects
    }

}