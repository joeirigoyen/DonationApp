package com.example.securityintegration.Views.SignIn

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignIn.RecoverPasswordViewModel
import com.example.securityintegration.databinding.RecoverPasswordFragmentBinding

class RecoverPasswordFrag : Fragment() {

    companion object {
        fun newInstance() = RecoverPasswordFrag()
    }

    private lateinit var viewModel: RecoverPasswordViewModel
    private lateinit var binding: RecoverPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecoverPasswordFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.editTextEmail.text.isEmpty()) {
                findNavController().navigate(R.id.action_recoverPasswordFrag_to_recoverPasswordSQFrag)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoverPasswordViewModel::class.java)
        // TODO: Use the ViewModel
    }

}