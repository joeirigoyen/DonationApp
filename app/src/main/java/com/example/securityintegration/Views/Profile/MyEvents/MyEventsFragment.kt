package com.example.securityintegration.Views.Profile.MyEvents

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.Models.User.UserService
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventListViewModel
import com.example.securityintegration.ViewModels.Profile.MyEventsViewModel
import com.example.securityintegration.Views.Profile.MyDonations.MyDonationsAdapter
import com.example.securityintegration.databinding.MyEventsFragmentBinding

class MyEventsFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = MyEventsFragment()
    }

    private lateinit var binding : MyEventsFragmentBinding
    private val viewModel: EventListViewModel by viewModels()
    private val adapter = MyEventsAdapter(arrayListOf())
    private val space = 20
    private val users = UserService().getUsers()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyEventsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Observers, events and adapter
        configObservers()
        configAdapter()
        configEvents()
        adapter.listener = this
    }

    private fun configEvents() {
        // Set element info to boxes
        viewModel.getEvents(users[0])
    }

    private fun configObservers() {
        viewModel.eventList.observe(viewLifecycleOwner) {
                eventList -> adapter.update(eventList)
        }
    }

    private fun configAdapter() {
        val recyclerView = binding.rvMyEventList
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick(pos: Int) {
        val event = adapter.evArray[pos]
        val action = MyEventsFragmentDirections.actionMyEventsFragmentToEventInfoFragment2(event)
        findNavController().navigate(action)
    }

}