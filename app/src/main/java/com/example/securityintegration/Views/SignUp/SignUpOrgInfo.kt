package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpOrgInfoFragmentBinding

class SignUpOrgInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpOrgInfo()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding : SignUpOrgInfoFragmentBinding
    private val args : SignUpOrgInfoArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpOrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.btnNext.setOnClickListener {
            val action = SignUpOrgInfoDirections.actionSignUpOrgInfoToSignUpMembership(binding.etOrgName.text.toString(), lastname1 = "", lastname2 = "", binding.etOrgUsername.text.toString(), binding.etOrgBirthdate.text.toString(), binding.etCountryOrg.text.toString(), binding.etOrgRFC.text.toString(), binding.etOrgDescription.text.toString(), args.accType)
            findNavController().navigate(action)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}