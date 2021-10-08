package com.example.securityintegration.ViewModels.Events

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.EventList.EventService
import com.example.securityintegration.Models.User.User

class EventListViewModel : ViewModel() {
    private val model = EventService()
    val eventList = MutableLiveData<List<Event>>()

    fun getEvents() {
        eventList.value = model.getEvents()
    }

    fun getEvents(user: User) {
        eventList.value = model.getEvents()
    }

}