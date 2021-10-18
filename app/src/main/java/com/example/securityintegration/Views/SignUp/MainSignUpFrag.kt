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
import androidx.navigation.NavDirections
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
            val action : NavDirections
            val passedArg: Int
            if (selection != -1) {
                // Go to next page
                if (selectedBtn.text.toString() == resources.getString(R.string.soy_un_inversionista_social)) {
                    passedArg = 1
                    action = MainSignUpFragDirections.actionMainSignUpFragToSignUpGeneralInfo(passedArg)
                    findNavController().navigate(action)
                } else if (selectedBtn.text.toString() ==resources.getString(R.string.represento_a_una_organizaci_n)) {
                    passedArg = 2
                    action = MainSignUpFragDirections.actionMainSignUpFragToSignUpOrgInfo(passedArg)
                    findNavController().navigate(action)
                }
            } else {
                Toast.makeText(activity, "Por favor selecciona una opción válida.", Toast.LENGTH_SHORT).show()
            }
        }
    }

}