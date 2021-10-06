package com.example.securityintegration.Views.OrgLookup

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
import com.example.securityintegration.databinding.OrgInfoFragmentBinding

class OrgInfoFragment : Fragment() {

    private val args : OrgInfoFragmentArgs by navArgs()
    private lateinit var binding : OrgInfoFragmentBinding
    private val viewModel : OrgInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgInfoFragmentBinding.inflate(layoutInflater)
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
        binding.tvOrgTitle.text = args.selection.name
        binding.tvOrgLookupDescription.text = args.selection.desc
        binding.tvOriginDate.text = args.selection.creationDate.date.toString()
        binding.tvNativeCountry.text = args.selection.nativeCountry
    }

}