package com.example.securityintegration.Views.SignUp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.securityintegration.Views.SignIn.MainActivity
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpNewPasswordFragmentBinding

class SignUpNewPassword : Fragment() {

    companion object {
        fun newInstance() = SignUpNewPassword()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding: SignUpNewPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpNewPasswordFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etEmail.text.isEmpty() && viewModel.isValidEmail(binding.etEmail.text.toString())) {
                if (!binding.etNewPW.text.isEmpty() && !binding.etConfirmPW.text.isEmpty()) {
                    if (binding.etNewPW.text.toString() == binding.etConfirmPW.text.toString()) {
                        Toast.makeText(activity, "Cuenta creada con éxito.", Toast.LENGTH_LONG).show()
                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()
                    } else {
                        Toast.makeText(activity, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(activity, "La contraseña no puede estar vacía.", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(activity, "Introduce un correo electrónico válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}