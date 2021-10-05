package com.example.securityintegration.Views.SignIn

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordNewPasswordViewModel
import com.example.securityintegration.databinding.RecoverPasswordNewPasswordFragmentBinding

class RecoverPasswordNewPassword : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordNewPassword()
    }

    private lateinit var viewModel: RecoverPasswordNewPasswordViewModel
    private lateinit var binding: RecoverPasswordNewPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecoverPasswordNewPasswordFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.editTextNewPW.text.isEmpty() && !binding.editTextPWConfirm.text.isEmpty()) {
                if (binding.editTextNewPW.text.toString() == binding.editTextPWConfirm.text.toString()) {
                    findNavController().navigate(R.id.action_recoverPasswordNewPassword_to_mainSignInFrag)
                    Toast.makeText(activity, "Contraseña actualizada correctamente.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoverPasswordNewPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }
}