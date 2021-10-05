package com.example.securityintegration.Views.SignUp

import android.content.Intent
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
import com.example.securityintegration.Views.SignIn.MainActivity
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.MainSignUpFragmentBinding

class MainSignUpFrag : Fragment() {

    companion object {
        fun newInstance() = MainSignUpFrag()
    }

    private val viewModel: MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding: MainSignUpFragmentBinding
    private lateinit var radioGroup: RadioGroup


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MainSignUpFragmentBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize variables
        radioGroup = requireActivity().findViewById(R.id.accTypesRGroup)
        val defaultBtn : RadioButton = requireActivity().findViewById(R.id.btnDefaultOption)
        var selection : Int = defaultBtn.id
        // Button events
        binding.btnLoginFromSignup.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
        binding.btnNext.setOnClickListener {
            selection = radioGroup.checkedRadioButtonId
            val selectedBtn : RadioButton = requireActivity().findViewById(selection)
            val selectionStr : String = selectedBtn.text.toString()
            Toast.makeText(activity, "$selection", Toast.LENGTH_LONG).show()
            if (selection != -1) {
                // Set selection id in viewModel
                viewModel.setSelectedBtnId(selectionStr, "account")
                Toast.makeText(activity, selectionStr, Toast.LENGTH_LONG).show()
                // Start navigation
                when (viewModel.getSelectedBtnId("account")) {
                    getString(R.string.soy_un_inversionista_social), getString(R.string.busco_contactar_con_inversionistas_y_o_organizaciones)-> findNavController().navigate(R.id.action_mainSignUpFrag_to_signUpGeneralInfo)
                    getString(R.string.represento_a_una_organizaci_n) -> findNavController().navigate(R.id.action_mainSignUpFrag_to_signUpOrgInfo)
                    else -> Toast.makeText(activity, "Por favor selecciona una opción válida.", Toast.LENGTH_SHORT).show()
                }
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