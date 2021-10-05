package com.example.securityintegration.Models.OrgLookup

// OrgList model which gets org list
class OrgService {

    fun getOrgs() : List<Org> {
        return arrayListOf(
            Org("Greenpeace", "Lorem ipsum greenpeace"),
            Org("YMCA Naucalpan", "Lorem ipsum ymca"),
            Org("Perros y Gatos S.A. de C.V.", "Lorem ipsum perros")
        )
    }

}
