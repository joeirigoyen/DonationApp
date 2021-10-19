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
import com.example.securityintegration.Models.API.APIInterface
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.UserExistsRequest
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordViewModel
import com.example.securityintegration.databinding.RecoverPasswordFragmentBinding

class RecoverPasswordFrag : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordFrag()
    }

    private lateinit var viewModel: APIViewModel
    private lateinit var binding: RecoverPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecoverPasswordFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.editTextEmail.text.isEmpty()) {
                if (isValidEmail(binding.editTextEmail.text.toString())) {
                    val request = UserExistsRequest(binding.editTextEmail.text.toString())
                    viewModel.postUserExists(request)
                    viewModel.userExistsResponse.observe(viewLifecycleOwner, Observer { response ->
                        if (response.isSuccessful) {
                            if (response.body()?.message!! == "true") {
                                val action = RecoverPasswordFragDirections.actionRecoverPasswordFragToRecoverPasswordSQFrag(binding.editTextEmail.text.toString())
                                findNavController().navigate(action)
                            } else {
                                Toast.makeText(requireContext(), "El correo no está registrado", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(requireContext(), "Error en el servidor. Intenta más tarde", Toast.LENGTH_SHORT).show()
                        }
                    })
                } else {
                    Toast.makeText(requireContext(), "Utiliza un correo válido", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "El correo no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun isValidEmail(email: String) : Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}