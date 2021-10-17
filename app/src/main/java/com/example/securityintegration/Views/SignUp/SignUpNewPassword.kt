package com.example.securityintegration.Views.SignUp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Views.SignIn.MainActivity
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpNewPasswordFragmentBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignUpNewPassword : Fragment() {

    companion object {
        fun newInstance() = SignUpNewPassword()
    }

    private val bd = Firebase.database
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
            if (!binding.etEmail.text.isEmpty()) {
                if (!binding.etNewPW.text.isEmpty() && !binding.etConfirmPW.text.isEmpty() && !binding.etSecurityQuestion.text.isEmpty() && !binding.etSecurityQuestionAnswer.text.isEmpty()) {
                    viewModel.secQuestion = binding.etSecurityQuestion.text.toString()
                    viewModel.secAnswer = binding.etSecurityQuestionAnswer.text.toString()
                    if (binding.etNewPW.text.toString() == binding.etConfirmPW.text.toString()) {
                        // Add info to viewModel
                            if (isValidEmail(binding.etEmail.text.toString())) {
                                viewModel.email = binding.etEmail.text.toString()
                                if (isValidPassword(binding.etNewPW.text.toString())) {
                                    viewModel.password = binding.etNewPW.text.toString()
                                    // Add everything to database

                                    // Go to sign-in page
                                    Toast.makeText(activity, "Cuenta creada con éxito.", Toast.LENGTH_LONG).show()
                                    val intent = Intent(activity, MainActivity::class.java)
                                    startActivity(intent)
                                    requireActivity().finish()
                                } else {
                                    Toast.makeText(requireContext(), "La contraseña debe tener al menos 8 caracteres (hasta 32 caracteres), al menos un número y una letra mayúscula.", Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(requireContext(), "Introduce un correo válido.", Toast.LENGTH_SHORT).show()
                            }
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

    fun isValidPassword(password : String) : Boolean {
        val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
        val matcher = Regex(pattern)
        return matcher.matches(password)
    }

    fun isValidEmail(email: String) : Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}