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
import androidx.core.view.isEmpty
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.UsernameRequest
import com.example.securityintegration.Models.User.ValidDateRequest
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpOrgInfoFragmentBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class SignUpOrgInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpOrgInfo()
    }

    private lateinit var viewModel : APIViewModel
    private lateinit var binding : SignUpOrgInfoFragmentBinding
    private val args : SignUpOrgInfoArgs by navArgs()

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
        binding = SignUpOrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bool = ""
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etOrgName.text.isEmpty() && !binding.etCountryOrg.text.isEmpty() && !binding.etOrgBirthdate.text.isEmpty() && !binding.etOrgRFC.text.isEmpty() && !binding.etCountryOrg.text.isEmpty() && !binding.etOrgDescription.text.isEmpty() && !binding.etOrgUsername.text.isEmpty()) {
                val request = ValidDateRequest(binding.etOrgBirthdate.text.toString())
                viewModel.isValidDate(request)
                viewModel.validDateResponse.observe(viewLifecycleOwner, Observer { response ->
                    if (response.isSuccessful) {
                        if (response.body()?.status!! == "failed") {
                            val action = SignUpOrgInfoDirections.actionSignUpOrgInfoSelf(args.accType)
                            findNavController().navigate(action)
                            //Toast.makeText(activity, "Por favor verifique que el formato de la fecha sea aaaa-mm-dd", Toast.LENGTH_SHORT).show()
                        } else {
                            val user = UsernameRequest(binding.etOrgUsername.text.toString())
                            viewModel.getUsernameExists(user)
                            viewModel.usernameResponse.observe(viewLifecycleOwner, Observer { response ->
                                if (response.isSuccessful) {
                                    Toast.makeText(activity, "Request: $user. Response: ${response.body()?.toString()}", Toast.LENGTH_LONG).show()
                                    response.let {
                                        if (it.body()?.message!! == "true") {
                                            //Toast.makeText(activity, "El nombre de usuario no está disponible", Toast.LENGTH_SHORT).show()
                                            val action = SignUpOrgInfoDirections.actionSignUpOrgInfoSelf(args.accType)
                                            findNavController().navigate(action)
                                        } else {
                                            val action = SignUpOrgInfoDirections.actionSignUpOrgInfoToSignUpMembership(binding.etOrgName.text.toString(), lastname1="", lastname2="", binding.etOrgUsername.text.toString(), binding.etOrgBirthdate.text.toString(), binding.etCountryOrg.text.toString(), binding.etOrgRFC.text.toString(), binding.etOrgDescription.text.toString(), args.accType)
                                            findNavController().navigate(action)
                                        }
                                    }
                                }
                            })
                        }
                    }
                })
            } else {
                Toast.makeText(activity, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}