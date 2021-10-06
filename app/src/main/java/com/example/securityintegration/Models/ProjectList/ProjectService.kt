package com.example.securityintegration.Models.ProjectList

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import com.example.securityintegration.Models.User.User
import java.sql.Date

class ProjectService {

    var orgs : List<Org> = OrgService().getOrgs()

    fun getProjects() : List<Project> {
        return arrayListOf(
            Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto D", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto E", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto D", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto E", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Dona por una dona", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Futbol con causa", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto D", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            )),
            Project("Proyecto E", "Lorem dona", orgs[0], listOf(
                User("Youthan", "Irigoyen", "Usuario", Date(121135), "youthan@gmail.com", "hello"),
                User("Eduardo", "Irigoyen", "Usuario", Date(121135), "eduardo@gmail.com", "hello"),
                User("Jared", "Irigoyen", "Usuario", Date(121135), "jared@gmail.com", "hello")
            ))
        )
    }

}