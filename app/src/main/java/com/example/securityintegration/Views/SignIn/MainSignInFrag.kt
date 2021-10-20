package com.example.securityintegration.Views.SignIn

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.API.RetrofitInstance
import com.example.securityintegration.Models.User.Login.LoginInputResponse
import com.example.securityintegration.Models.User.Login.LoginResponse
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
                                    Log.d("BODY", response.body().toString())
                                    intent.putExtra("username", response.body()?.username!!)
                                    intent.putExtra("names", response.body()?.names!!)
                                    intent.putExtra("accType", response.body()?.accType!!)
                                    startActivity(intent)
                                    requireActivity().finish()
                                } else if (response.body()?.message!! == "inexistent") {
                                    Toast.makeText(requireContext(), "El nombre de usuario no existe.", Toast.LENGTH_SHORT).show()
                                } else if (response.body()?.message!! == "false") {
                                    Toast.makeText(requireContext(), "Las credenciales son incorrectas.", Toast.LENGTH_SHORT).show()
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

        binding.btnTyC.setOnClickListener {
            val intent = Intent("android.intent.action.VIEW", Uri.parse("https://www.termsandconditionsgenerator.com/live.php?token=HNIXHM6LZQT2mNnzIyOAXHT8Nx4hLpTC"))
            startActivity(intent)
        }

        binding.btnPriv.setOnClickListener {
            val intent = Intent("android.intent.action.VIEW", Uri.parse("https://www.privacypolicygenerator.info/live.php?token=kMOOomXopp1z7HUqIgLh2s93101AgoJa"))
            startActivity(intent)
        }

    }
}