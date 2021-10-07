package com.example.securityintegration.Views.Projects

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.OrgLookup.OrgInfoViewModel
import com.example.securityintegration.ViewModels.Projects.ProjectInfoViewModel
import com.example.securityintegration.Views.OrgLookup.OrgInfoFragmentArgs
import com.example.securityintegration.databinding.OrgInfoFragmentBinding
import com.example.securityintegration.databinding.ProjectInfoFragmentBinding

class ProjectInfoFragment : Fragment() {

    private val args : ProjectInfoFragmentArgs by navArgs()
    private lateinit var binding : ProjectInfoFragmentBinding
    private val viewModel : ProjectInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        //configObservers()
    }

    private fun configObservers() {

    }

    private fun configView() {
        binding.tvProjectTitle.text = args.selectedProject.name
        binding.tvProjLookupDescription.text = args.selectedProject.desc
        binding.tvProjectCreator.text = args.selectedProject.org.name
    }

}