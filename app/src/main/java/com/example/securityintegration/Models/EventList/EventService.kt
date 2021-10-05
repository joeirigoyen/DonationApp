package com.example.securityintegration.Models.EventList

import com.example.securityintegration.Models.OrgLookup.Org
import java.sql.Time
import java.util.*

class EventService {

    fun getEvents() : List<Event> {
        return arrayListOf(
            Event("Día de la donación", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Día del perro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 10, 25), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Día de la gratitud", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 11, 1), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Pon un precio", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Rifa de peluches", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Kermés con propósito", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Celebración de la amistad", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Día del gato", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Evento 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit")),
            Event("Evento final", "Lorem ipsum dolor sit amet, consectetur adipiscing elit", Date(2021, 12, 30), Org("YMCA", "Lorem ipsum dolor sit amet, consectetur adipiscing elit"))
        )
    }

}