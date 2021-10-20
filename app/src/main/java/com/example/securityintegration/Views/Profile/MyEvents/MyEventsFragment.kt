package com.example.securityintegration.Views.Profile.MyEvents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.Models.EventList.UserEventRequest
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.MyEventsFragmentBinding

class MyEventsFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = MyEventsFragment()
    }

    lateinit var act : MainPageActivity
    private lateinit var binding : MyEventsFragmentBinding
    private lateinit var viewModel: APIViewModel
    private val adapter = MyEventsAdapter(arrayListOf())
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
        if (activity != null) {
            act = activity as MainPageActivity
            val user = UserEventRequest(act.accNames)
            viewModel.getEventsFrom(user)
            viewModel.eventFromResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {
                    response.body()?.let { adapter.setData(it) }
                }
            })
        }
    }

    private fun configObservers() {
        // Show events
        viewModel.myEventsResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.let { adapter.setData(it) }
            }
        })
        // Button listener
        binding.btnBack.setOnClickListener {
            val action = MyEventsFragmentDirections.actionMyEventsFragmentToProfileFragment()
            findNavController().navigate(action)
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
        //Nada
    }

}