package com.example.securityintegration.Views.SignIn

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordSQViewModel
import com.example.securityintegration.databinding.RecoverPasswordSQFragmentBinding

class RecoverPasswordSQFrag : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordSQFrag()
    }

    private lateinit var viewModel: RecoverPasswordSQViewModel
    private lateinit var binding: RecoverPasswordSQFragmentBinding

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
        // Button events
        binding.nextBtnSQ.setOnClickListener {
            if (!binding.editTextBD.text.isEmpty() && !binding.editTextSQ.text.isEmpty()) {
                findNavController().navigate(R.id.action_recoverPasswordSQFrag_to_recoverPasswordNewPassword)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoverPasswordSQViewModel::class.java)
        // TODO: Use the ViewModel
    }

}