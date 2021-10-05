package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpMembershipFragmentBinding

class SignUpMembership : Fragment() {

    companion object {
        fun newInstance() = SignUpMembership()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding: SignUpMembershipFragmentBinding
    private lateinit var radioGroup: RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SignUpMembershipFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set button variables
        radioGroup = requireActivity().findViewById(R.id.memTypesRGroup)
        val defaultBtn : RadioButton = requireActivity().findViewById(R.id.btnDefaultOption)
        var selection : Int = defaultBtn.id
        // Button events
        binding.btnNext.setOnClickListener {
            selection = radioGroup.checkedRadioButtonId
            val selectedBtn : RadioButton = requireActivity().findViewById(selection)
            val selectionStr : String = selectedBtn.text.toString()
            if (selection != -1) {
                // Set selection id in viewModel
                viewModel.setSelectedBtnId(selectionStr, "membership")
                Toast.makeText(activity, selectionStr, Toast.LENGTH_LONG).show()
                // Navigate
                findNavController().navigate(R.id.action_signUpMembership_to_signUpPaymentMethod)
            } else {
                Toast.makeText(activity, "Por favor selecciona una opción válida.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }
}