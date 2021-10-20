/*
* Autor: Raúl Youthan Irigoyen Osorio
* */

package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.UsernameRequest
import com.example.securityintegration.Models.User.ValidDateRequest
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpGeneralInfoFragmentBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class SignUpGeneralInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpGeneralInfo()
    }
    // ViewModel
    private lateinit var viewModel : APIViewModel
    // Args
    private val args : SignUpGeneralInfoArgs by navArgs()
    // View binding
    private lateinit var binding : SignUpGeneralInfoFragmentBinding

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
        binding = SignUpGeneralInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
                // Check date
                val request = ValidDateRequest(birthdate)
                viewModel.isValidDate(request)
                viewModel.validDateResponse.observe(viewLifecycleOwner, Observer { response ->
                    if (response.isSuccessful) {
                        if (response.body()?.status!! == "failed") {
                            //Toast.makeText(activity, "Por favor verifique que el formato de la fecha sea aaaa-mm-dd", Toast.LENGTH_SHORT).show()
                            val action = SignUpGeneralInfoDirections.actionSignUpGeneralInfoSelf(args.accType)
                            findNavController().navigate(action)
                        } else {
                            val user = UsernameRequest(binding.etUsername.text.toString())
                            viewModel.getUsernameExists(user)
                            viewModel.usernameResponse.observe(viewLifecycleOwner, Observer { response ->
                                if (response.isSuccessful) {
                                    response.let {
                                        if (it.body()?.message!! == "true") {
                                            Toast.makeText(activity, "El nombre de usuario no está disponible", Toast.LENGTH_SHORT).show()
                                            val action = SignUpGeneralInfoDirections.actionSignUpGeneralInfoSelf(args.accType)
                                            findNavController().navigate(action)
                                        } else {
                                            val action = SignUpGeneralInfoDirections.actionSignUpGeneralInfoToSignUpMembership(names, lastname1, lastname2, username, birthdate, country, rfc, desc="", args.accType)
                                            findNavController().navigate(action)
                                        }
                                    }
                                } else {
                                    Toast.makeText(activity, "Error con el servidor. Intente más tarde", Toast.LENGTH_SHORT).show()
                                }
                            })
                        }
                    } else {
                        Toast.makeText(activity, "Error en el servidor", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(activity, "Por favor llena toda la información solicitada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}