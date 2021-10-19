package com.example.securityintegration.Views.SignIn

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.NewPasswordRequest
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordNewPasswordViewModel
import com.example.securityintegration.databinding.RecoverPasswordNewPasswordFragmentBinding

class RecoverPasswordNewPassword : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordNewPassword()
    }

    private val args : RecoverPasswordNewPasswordArgs by navArgs()
    private lateinit var viewModel: APIViewModel
    private lateinit var binding: RecoverPasswordNewPasswordFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

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
                    if (isValidPassword(binding.editTextNewPW.text.toString())) {
                        val request = NewPasswordRequest(binding.editTextNewPW.text.toString(), args.email)
                        viewModel.putNewPassword(request)
                        viewModel.newPasswordResponse.observe(viewLifecycleOwner, Observer { response ->
                            if (response.isSuccessful) {
                                if (response.body()?.message == "done") {
                                    Toast.makeText(activity, "Contraseña actualizada correctamente.", Toast.LENGTH_LONG).show()
                                } else {
                                    Toast.makeText(activity, "Error en el servidor. Intente más tarde", Toast.LENGTH_LONG).show()
                                }
                            } else {
                                Toast.makeText(activity, "La contraseña debe tener al menos 8 caracteres (hasta 32 caracteres), al menos un número y una letra mayúscula.", Toast.LENGTH_SHORT).show()
                            }
                        })
                        findNavController().navigate(R.id.action_recoverPasswordNewPassword_to_mainSignInFrag)
                    }
                }
            }
        }
    }
}

fun isValidPassword(password : String) : Boolean {
    val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$"
    val matcher = Regex(pattern)
    return matcher.matches(password)
}