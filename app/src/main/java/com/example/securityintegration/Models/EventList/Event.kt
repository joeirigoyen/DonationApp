package com.example.securityintegration.Models.EventList

import com.example.securityintegration.Models.OrgLookup.Org
import java.io.Serializable
import java.util.*

data class Event (val id_event: Int, val nombre: String, val descripcion: String, val fecha_evento: String, val org_creadora: String) : Serializable