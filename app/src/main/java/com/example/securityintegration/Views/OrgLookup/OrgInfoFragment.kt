package com.example.securityintegration.Views.OrgLookup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.OrgLookup.OrgInfoViewModel
import com.example.securityintegration.databinding.OrgInfoFragmentBinding

class OrgInfoFragment : Fragment() {

    companion object {
        fun newInstance() = OrgInfoFragment()
    }

    private lateinit var binding : OrgInfoFragmentBinding
    private val viewModel: OrgInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }
}