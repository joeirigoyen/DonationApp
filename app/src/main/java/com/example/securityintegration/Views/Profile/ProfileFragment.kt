package com.example.securityintegration.Views.Profile

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Profile.ProfileViewModel
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var binding : ProfileFragmentBinding
    private lateinit var arg : String
    private val viewModel : ProfileViewModel by viewModels()

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController
    lateinit var act : MainPageActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            act = activity as MainPageActivity
            binding.tvProfileName.text = act.accNames
            binding.tvProfileUsername.text = "@${act.accUsername}"
        }

        binding.btnMyProjects.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_myProjectsFragment)
        }
        binding.btnMyDonations.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_myDonationsFragment)
        }
        binding.btnMyEvents.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_myEventsFragment)
        }
    }
}