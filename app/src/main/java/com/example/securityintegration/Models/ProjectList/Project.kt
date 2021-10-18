package com.example.securityintegration.Models.ProjectList

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.User.User
import java.io.Serializable

data class Project (val id_proyecto: Int, val nombre: String, val descripcion: String, val org_creadora: String) : Serializable