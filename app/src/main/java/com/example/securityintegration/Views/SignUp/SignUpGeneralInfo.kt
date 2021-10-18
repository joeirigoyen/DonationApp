package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpGeneralInfoFragmentBinding

class SignUpGeneralInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpGeneralInfo()
    }
    // ViewModel
    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    // Args
    private val args : SignUpGeneralInfoArgs by navArgs()
    // View binding
    private lateinit var binding : SignUpGeneralInfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpGeneralInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(activity, "${args.accType}", Toast.LENGTH_SHORT).show()
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etNames.text.isEmpty() && !binding.etLastName1.text.isEmpty() && !binding.etLastName2.text.isEmpty() && !binding.etUsername.text.isEmpty() && !binding.etBirthdate.text.isEmpty() && !binding.etCountry.text.isEmpty()) {
                // Pass data to viewModel
                val names = binding.etNames.text.toString().trim()
                val lastname1 = binding.etLastName1.text.toString().trim()
                val lastname2 = binding.etLastName2.text.toString().trim()
                val username = binding.etUsername.text.toString().trim()
                val birthdate = binding.etBirthdate.text.toString().trim()
                val country = binding.etCountry.text.toString().trim()
                val rfc = binding.etRFC.text.toString().trim()
                // Navigate
                val action = SignUpGeneralInfoDirections.actionSignUpGeneralInfoToSignUpMembership(names, lastname1, lastname2, username, birthdate, country, rfc, desc="", args.accType)
                findNavController().navigate(action)
            } else {
                Toast.makeText(activity, "Por favor llena toda la información solicitada.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}