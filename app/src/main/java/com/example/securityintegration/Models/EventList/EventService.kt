package com.example.securityintegration.Models.EventList

import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.Models.OrgLookup.OrgService
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList

class EventService {

    var orgs : List<Org> = OrgService().getOrgs()

    fun getEvents() : List<Event> {
        return arrayListOf(
            Event("Día de la donación", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Día del perro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 10, 25), orgs[0]),
            Event("Día de la gratitud", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 11, 1), orgs[0]),
            Event("Pon un precio", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Rifa de peluches", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Kermés con propósito", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Celebración de la amistad", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Día del gato", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Evento 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0]),
            Event("Evento final", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), orgs[0])
        )
    }

}