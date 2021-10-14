package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpGeneralInfoFragmentBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpGeneralInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpGeneralInfo()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
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

        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etNames.text.isEmpty() && !binding.etLastName1.text.isEmpty() && !binding.etLastName2.text.isEmpty() && !binding.etUsername.text.isEmpty() && !binding.etBirthdate.text.isEmpty() && !binding.etCountry.text.isEmpty()) {
                // Pass data to viewModel
                viewModel.names = binding.etNames.text.toString().trim()
                viewModel.firstLastName = binding.etLastName1.text.toString().trim()
                viewModel.secondLastName = binding.etLastName2.text.toString().trim()
                viewModel.username = binding.etUsername.text.toString().trim()
                viewModel.birthDate = binding.etBirthdate.text.toString().trim()
                viewModel.country = binding.etCountry.text.toString().trim()
                // Navigate
                findNavController().navigate(R.id.action_signUpGeneralInfo_to_signUpMembership)
            } else {
                Toast.makeText(activity, "Por favor llena toda la información solicitada.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}