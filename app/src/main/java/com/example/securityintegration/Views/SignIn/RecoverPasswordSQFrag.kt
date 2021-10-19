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
import com.example.securityintegration.Models.User.QuestionRequest
import com.example.securityintegration.Models.User.ValidateQuestionRequest
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordSQViewModel
import com.example.securityintegration.databinding.RecoverPasswordSQFragmentBinding

class RecoverPasswordSQFrag : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordSQFrag()
    }

    private var arg : String = "Pregunta de seguridad"
    private lateinit var viewModel: APIViewModel
    private lateinit var binding: RecoverPasswordSQFragmentBinding
    private val args : RecoverPasswordSQFragArgs by navArgs()

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
        binding =  RecoverPasswordSQFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get security question
        val request = QuestionRequest(args.email)
        viewModel.postGetQuestion(request)
        viewModel.questionResponse.observe(viewLifecycleOwner, Observer { response ->
            if (response.isSuccessful) {
                if (response.body() != null) {
                    if (response.body()!!.message == "true") {
                        arg = response.body()!!.sec_q
                        binding.editTextSQ.setHint(arg)
                    }
                }
            }
        })
        // Button events
        binding.nextBtnSQ.setOnClickListener {
            if (!binding.editTextBD.text.isEmpty() && !binding.editTextSQ.text.isEmpty()) {
                val vrequest = ValidateQuestionRequest(args.email, binding.editTextSQ.text.toString())
                viewModel.postValidateQuestion(vrequest)
                viewModel.validateQuestionResponse.observe(viewLifecycleOwner, Observer { response ->
                    if (response.isSuccessful) {
                        if (response.body()?.message == "true") {
                            val action = RecoverPasswordSQFragDirections.actionRecoverPasswordSQFragToRecoverPasswordNewPassword(args.email, binding.editTextSQ.text.toString())
                            findNavController().navigate(action)
                        } else {
                            Toast.makeText(requireContext(), "La respuesta es incorrecta", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(requireContext(), "Error en el servidor. Intente más tarde", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(requireContext(), "Por favor llena todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}