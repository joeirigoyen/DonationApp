package com.example.securityintegration.Views.Profile.MyEvents

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.EventList.EventCreator
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.CreateEventFragmentBinding

class CreateEventFragment : Fragment() {

    companion object {
        fun newInstance() = CreateEventFragment()
    }

    private lateinit var binding : CreateEventFragmentBinding
    private lateinit var viewModel: APIViewModel
    lateinit var act : MainPageActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CreateEventFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configEvents()
    }

    private fun configEvents() {
        if (activity != null) {
            act = activity as MainPageActivity
            binding.btnBack.setOnClickListener {
                val action = CreateEventFragmentDirections.actionCreateEventFragmentToEventListFragment()
                findNavController().navigate(action)
            }
            binding.btnNext.setOnClickListener {
                if (!binding.etEventName.text.isEmpty()) {
                    if (!binding.etEventDate.text.isEmpty()) {
                        if (!binding.etEventDesc.text.isEmpty()) {
                            val event = EventCreator(binding.etEventName.text.toString(), binding.etEventDesc.text.toString(), binding.etEventDate.text.toString(), act.accNames)
                            viewModel.postEvent(event)
                            viewModel.eventResponse.observe(viewLifecycleOwner, Observer { response ->
                                if (response.isSuccessful) {
                                    if (response.code() == 200) {
                                        Toast.makeText(requireContext(), "¡Evento creado con éxito!", Toast.LENGTH_SHORT).show()
                                        val action = CreateEventFragmentDirections.actionCreateEventFragmentToEventListFragment()
                                        findNavController().navigate(action)
                                    } else {
                                        Toast.makeText(requireContext(), "Ocurrió un error con el servidor. Intenta de nuevo.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            })
                        } else {
                            Toast.makeText(requireContext(), "¡Describe tu evento!", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "¡Agrega una fecha para tu evento!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "¡Dale un nombre a tu evento!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}