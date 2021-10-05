package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpPaymentMethodFragmentBinding

class SignUpPaymentMethod : Fragment() {

    companion object {
        fun newInstance() = SignUpPaymentMethod()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding: SignUpPaymentMethodFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpPaymentMethodFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set editTexts' with the name of the person
        if (viewModel.getSelectedBtnId("account") == getString(R.string.soy_un_inversionista_social)) {
            binding.etNames.setText(viewModel.getGeneralInfo("name"))
            binding.etLastName1.setText(viewModel.getGeneralInfo("firstLastName"))
            binding.etLastName2.setText(viewModel.getGeneralInfo("secondLastName"))
        }
        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etNames.text.isEmpty() && !binding.etLastName1.text.isEmpty() && !binding.etLastName2.text.isEmpty() && !binding.etCardNumber.text.isEmpty() && !binding.etCVV.text.isEmpty() && !binding.expDate.text.isEmpty()) {
                findNavController().navigate(R.id.action_signUpPaymentMethod_to_signUpNewPassword)
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}