package com.example.securityintegration.Views.Landing

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.ViewModels.Landing.LandingViewModel
import com.example.securityintegration.Views.OrgLookup.OrgsLookupActivity
import com.example.securityintegration.databinding.LandingFragmentBinding

class LandingFragment : Fragment() {

    companion object {
        fun newInstance() = LandingFragment()
    }

    private val viewModel: LandingViewModel by viewModels()
    private lateinit var binding : LandingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LandingFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.bntOrgLookup.setOnClickListener {
            val intent = Intent(activity, OrgsLookupActivity::class.java)
            startActivity(intent)
        }
    }

}