package com.example.securityintegration.Views.SignIn

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.API.RetrofitInstance
import com.example.securityintegration.Models.User.LoginInputResponse
import com.example.securityintegration.Models.User.LoginResponse
import com.example.securityintegration.Views.SignUp.MainSignUpActivity
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.MainSignInFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Sign-in view administrator fragment
class MainSignInFrag : Fragment() {

    companion object {
        fun newInstance() = MainSignInFrag()
    }

    private lateinit var viewModel: APIViewModel
    private lateinit var binding : MainSignInFragmentBinding

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
            val intent = Intent(activity, MainPageActivity::class.java)
            if (!binding.editTextUsername.text.isEmpty()) {
                if (!binding.editTextPassword.text.isEmpty()) {
                    // Attempt login
                    val login = LoginInputResponse(binding.editTextUsername.text.toString(), binding.editTextPassword.text.toString())
                    RetrofitInstance.api.postLogin(login)
                        .enqueue(object : Callback<LoginResponse>{
                            override fun onResponse(
                                call: Call<LoginResponse>,
                                response: Response<LoginResponse>
                            ) {
                                if (response.body()?.message!! == "true") {
                                    startActivity(intent)
                                    requireActivity().finish()
                                }
                            }
                            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                                Toast.makeText(requireContext(), "Error en el servidor. Intente de nuevo.", Toast.LENGTH_SHORT).show()
                            }

                        })
                } else {
                    Toast.makeText(requireContext(), "La contraseña no puede estar vacía", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "El nombre de usuario no puede estar vacío", Toast.LENGTH_SHORT).show()
            }

        }
    }
}