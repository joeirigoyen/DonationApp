package com.example.securityintegration.Views.Events

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventInfoViewModel
import com.example.securityintegration.ViewModels.OrgLookup.OrgInfoViewModel
import com.example.securityintegration.Views.OrgLookup.OrgInfoFragmentArgs
import com.example.securityintegration.databinding.EventInfoFragmentBinding
import com.example.securityintegration.databinding.OrgInfoFragmentBinding

class EventInfoFragment : Fragment() {

    private val args : EventInfoFragmentArgs by navArgs()
    private lateinit var binding : EventInfoFragmentBinding
    private val viewModel : EventInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EventInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        //congObservers()
    }

    private fun configObservers() {

    }

    private fun configView() {
        binding.tvEventTitle.text = args.selectedEvent.name
        binding.tvEventDate.text = args.selectedEvent.date.toString()
        binding.tvEventOrg.text = args.selectedEvent.creator.name
        binding.tvEventDescription.text = args.selectedEvent.desc
        // Switch button visibility according to user type
    }
}