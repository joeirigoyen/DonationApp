package com.example.securityintegration.Views.Profile.MyProjects

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
import com.example.securityintegration.Models.ProjectList.ProjectRequest
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.Views.Profile.MyEvents.CreateEventFragmentDirections
import com.example.securityintegration.databinding.CreateEventFragmentBinding
import com.example.securityintegration.databinding.CreateProjectFragmentBinding

class CreateProjectFragment : Fragment() {

    companion object {
        fun newInstance() = CreateProjectFragment()
    }

    private lateinit var binding : CreateProjectFragmentBinding
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
        binding = CreateProjectFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configEvents()
    }

    fun configEvents() {
        if (activity != null) {
            act = activity as MainPageActivity
            binding.btnBack.setOnClickListener {
                val action = CreateProjectFragmentDirections.actionCreateProjectFragmentToProjectListFragment()
                findNavController().navigate(action)
            }
            binding.btnNext.setOnClickListener {
                if (!binding.etProjectName.text.isEmpty()) {
                    if (!binding.etProjectDesc.text.isEmpty()) {
                        val project = ProjectRequest(binding.etProjectName.text.toString(), binding.etProjectDesc.text.toString(), act.accNames)
                        viewModel.postProject(project)
                        viewModel.myProjectsResponse.observe(viewLifecycleOwner, Observer { response ->
                            if (response.isSuccessful) {
                                if (response.code() == 200) {
                                    Toast.makeText(requireContext(), "¡Proyecto creado con éxito!", Toast.LENGTH_SHORT).show()
                                    val action = CreateProjectFragmentDirections.actionCreateProjectFragmentToProjectListFragment()
                                    findNavController().navigate(action)
                                } else {
                                    Toast.makeText(requireContext(), "Ocurrió un error con el servidor. Intenta de nuevo.", Toast.LENGTH_SHORT).show()
                                }
                            }
                        })
                    } else {
                        Toast.makeText(requireContext(), "¡Agrega una fecha para tu proyecto!", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "¡Dale un nombre a tu proyecto!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}