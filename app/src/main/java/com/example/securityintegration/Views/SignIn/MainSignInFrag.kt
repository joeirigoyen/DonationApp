package com.example.securityintegration.Views.SignIn

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.Views.SignUp.MainSignUpActivity
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignIn.MainSignInViewModel
import com.example.securityintegration.Views.Landing.LandingActivity
import com.example.securityintegration.databinding.MainSignInFragmentBinding

// Sign-in view administrator fragment
class MainSignInFrag : Fragment() {

    companion object {
        fun newInstance() = MainSignInFrag()
    }

    private val viewModel: MainSignInViewModel by viewModels()
    private lateinit var binding : MainSignInFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Set binding
        binding = MainSignInFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.forgotBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainSignInFrag_to_recoverPasswordFrag)
        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(activity, MainSignUpActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnLogin.setOnClickListener {
            val intent = Intent(activity, LandingActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}