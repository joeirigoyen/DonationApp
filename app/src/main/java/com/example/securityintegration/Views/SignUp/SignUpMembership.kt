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
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpMembershipFragmentBinding

class SignUpMembership : Fragment() {

    companion object {
        fun newInstance() = SignUpMembership()
    }
    // ViewModel
    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    // View binding
    private lateinit var binding: SignUpMembershipFragmentBinding
    private lateinit var radioGroup: RadioGroup
    // Args
    private val args : SignUpMembershipArgs by navArgs()

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
            var memType  = 0
            if (selection != -1) {
                // Set selection id in viewModel
                if (selectedBtn.text.toString() == resources.getString(R.string.b_sica_0_00)) {
                    memType = 1
                } else if (selectedBtn.text.toString() == resources.getString(R.string.premium_0_01)) {
                    memType = 2
                } else if (selectedBtn.text.toString() == resources.getString(R.string.vip_0_02_mes)) {
                    memType = 3
                }
                // Navigate
                val action = SignUpMembershipDirections.actionSignUpMembershipToSignUpNewPassword(args.names, args.lastname1, args.lastname2, args.username, args.birthdate, args.country, args.rfc, args.desc, args.accType, memType)
                findNavController().navigate(action)
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