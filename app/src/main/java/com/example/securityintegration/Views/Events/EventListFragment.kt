package com.example.securityintegration.Views.Events

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
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventListViewModel
import com.example.securityintegration.Views.OrgLookup.EventListAdapter
import com.example.securityintegration.databinding.EventListFragmentBinding
import com.example.securityintegration.databinding.OrgListFragmentBinding

class EventListFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = EventListFragment()
    }

    private lateinit var binding: EventListFragmentBinding
    private val viewModel: EventListViewModel by viewModels()
    private val adapter = EventListAdapter(arrayListOf())
    private val space = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventListFragmentBinding.inflate(layoutInflater)
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
        viewModel.getEvents()
    }

    private fun configObservers() {
        viewModel.eventList.observe(viewLifecycleOwner) {
                eventList -> adapter.update(eventList)
        }
    }

    private fun configAdapter() {
        val recyclerView = binding.rvEventList
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick (pos: Int)
    {
        val event = adapter.evArray[pos]
        val action = EventListFragmentDirections.actionEventListFragment2ToEventInfoFragment(event)
        findNavController().navigate(action)
    }

}