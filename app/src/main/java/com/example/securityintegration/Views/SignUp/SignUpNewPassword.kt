package com.example.securityintegration.Views.SignUp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.UserResponse
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.SignIn.MainActivity
import com.example.securityintegration.databinding.SignUpNewPasswordFragmentBinding

class SignUpNewPassword : Fragment() {

    companion object {
        fun newInstance() = SignUpNewPassword()
    }

    // ViewModel
    private lateinit var viewModel: APIViewModel
    // View binding
    private lateinit var binding: SignUpNewPasswordFragmentBinding
    // Args
    private val args : SignUpNewPasswordArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpNewPasswordFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        Toast.makeText(requireContext(), args.names, Toast.LENGTH_SHORT).show()
        binding.btnNext.setOnClickListener {
            if (!binding.etEmail.text.isEmpty()) {
                if (!binding.etNewPW.text.isEmpty() && !binding.etConfirmPW.text.isEmpty() && !binding.etSecurityQuestion.text.isEmpty() && !binding.etSecurityQuestionAnswer.text.isEmpty()) {
                    if (binding.etNewPW.text.toString() == binding.etConfirmPW.text.toString()) {
                        // Add info to viewModel
                            if (isValidEmail(binding.etEmail.text.toString())) {
                                if (isValidPassword(binding.etNewPW.text.toString())) {
                                    // Add everything to database
                                    if (args.accType == 1) {
                                        val user = UserResponse(
                                            args.names,
                                            args.lastname1,
                                            args.lastname2,
                                            args.birthdate,
                                            args.accType,
                                            args.rfc,
                                            binding.etEmail.text.toString(),
                                            binding.etNewPW.text.toString(),
                                            args.username,
                                            args.memType,
                                            binding.etSecurityQuestion.text.toString(),
                                            binding.etSecurityQuestionAnswer.text.toString(),
                                            args.country,
                                            args.desc
                                        )
                                        try {
                                            viewModel.postUser(user)
                                        } catch (e: com.google.gson.stream.MalformedJsonException) {
                                            Toast.makeText(requireContext(), "Cuenta creada con éxito.", Toast.LENGTH_SHORT).show()
                                        }
                                    } else if (args.accType == 2) {
                                        val user = UserResponse(
                                            args.names,
                                            args.lastname1,
                                            args.lastname2,
                                            args.birthdate,
                                            args.accType,
                                            args.rfc,
                                            binding.etEmail.text.toString(),
                                            binding.etNewPW.text.toString(),
                                            args.username,
                                            args.memType,
                                            binding.etSecurityQuestion.text.toString(),
                                            binding.etSecurityQuestionAnswer.text.toString(),
                                            args.country,
                                            args.desc
                                        )
                                        try {
                                            viewModel.postUser(user)
                                        } catch (e: com.google.gson.stream.MalformedJsonException) {
                                            Toast.makeText(requireContext(), "Cuenta creada con éxito.", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                                    // Go to sign-in page
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