package com.example.securityintegration.Models.OrgLookup

import java.util.*

// OrgList model which gets org list
class OrgService {

    fun getOrgs() : List<Org> {
        return arrayListOf(
            Org("Greenpeace", "Lorem ipsum greenpeace", Date(2020, 6, 18), "México"),
            Org("YMCA Naucalpan", "Lorem ipsum ymca", Date(2011, 2, 21), "México"),
            Org("Perros y Gatos S.A. de C.V.", "Lorem ipsum perros", Date(2018, 1, 13), "México")
        )
    }

}
