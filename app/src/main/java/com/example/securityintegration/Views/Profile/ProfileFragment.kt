package com.example.securityintegration.Views.Profile

import android.annotation.SuppressLint
import android.content.Intent
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
import com.example.securityintegration.Views.SignIn.MainActivity
import com.example.securityintegration.databinding.ProfileFragmentBinding

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var binding : ProfileFragmentBinding

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
        // Set account type-dependant elements
        if (activity != null) {
            act = activity as MainPageActivity
            binding.tvProfileName.text = act.accNames
            binding.tvProfileUsername.text = "@${act.accUsername}"
            if (act.accType == 1) {
                binding.trEventsRow.visibility = View.GONE
                binding.trProjectsRow.visibility = View.GONE
                binding.trDonationsRow.visibility = View.VISIBLE
                binding.cvProgress.visibility = View.VISIBLE
            } else {
                binding.trEventsRow.visibility = View.VISIBLE
                binding.trProjectsRow.visibility = View.VISIBLE
                binding.trDonationsRow.visibility = View.GONE
                binding.cvProgress.visibility = View.GONE
            }
        }

        binding.btnMyEvents.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToMyEventsFragment()
            findNavController().navigate(action)
        }

        binding.btnMyProjects.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToMyProjectsFragment()
            findNavController().navigate(action)
        }

        binding.btnMyDonations.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragmentToMyDonationsFragment()
            findNavController().navigate(action)
        }

        binding.btnProfileSettings.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}