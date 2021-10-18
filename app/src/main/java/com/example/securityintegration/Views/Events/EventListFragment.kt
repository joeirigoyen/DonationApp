package com.example.securityintegration.Views.Events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.OrgLookup.EventListAdapter
import com.example.securityintegration.databinding.EventListFragmentBinding

class EventListFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = EventListFragment()
    }

    private lateinit var binding: EventListFragmentBinding
    private lateinit var viewModel: APIViewModel
    private val adapter = EventListAdapter(arrayListOf())
    private val space = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

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
        adapter.listener = this
    }

    private fun configObservers() {
        viewModel.getEvents()
        viewModel.myEventsResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it)}
            }
        })
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
        val action = EventListFragmentDirections.actionEventListFragmentToEventInfoFragment(event)
        findNavController().navigate(action)
    }

}