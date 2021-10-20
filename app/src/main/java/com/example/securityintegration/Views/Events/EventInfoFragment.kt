package com.example.securityintegration.Views.Events

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventInfoViewModel
import com.example.securityintegration.ViewModels.OrgLookup.OrgInfoViewModel
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.Views.OrgLookup.OrgInfoFragmentArgs
import com.example.securityintegration.databinding.EventInfoFragmentBinding
import com.example.securityintegration.databinding.OrgInfoFragmentBinding

class EventInfoFragment : Fragment() {

    lateinit var act : MainPageActivity
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
        configObservers()
    }

    private fun configObservers() {
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_eventInfo1_to_eventListFragment)
        }
    }

    private fun configView() {
        binding.tvEventTitle.text = args.selectedEvent.nombre
        binding.tvEventDate.text = args.selectedEvent.fecha_evento
        binding.tvEventOrg.text = args.selectedEvent.org_creadora
        binding.tvEventDescription.text = args.selectedEvent.descripcion
        // Switch button visibility according to user type
        if (activity != null) {
            act = activity as MainPageActivity
            if (act.accType == 1) {
                binding.btnRegisterToProject.visibility = View.VISIBLE
            } else {
                binding.btnRegisterToProject.visibility = View.GONE
            }
        }
    }
}