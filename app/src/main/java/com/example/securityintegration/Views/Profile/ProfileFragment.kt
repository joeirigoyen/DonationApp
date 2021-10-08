package com.example.securityintegration.Views.Profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Profile.ProfileViewModel
import com.example.securityintegration.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var binding : ProfileFragmentBinding
    private val viewModel : ProfileViewModel by viewModels()

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnMyProjects.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_myProjectsFragment)
        }
    }
}