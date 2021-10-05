package com.example.securityintegration.Views.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.SignUp.MainSignUpViewModel
import com.example.securityintegration.databinding.SignUpGeneralInfoFragmentBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class SignUpGeneralInfo : Fragment() {

    companion object {
        fun newInstance() = SignUpGeneralInfo()
    }

    private val viewModel : MainSignUpViewModel by viewModels(
        ownerProducer = {requireActivity()}
    )
    private lateinit var binding : SignUpGeneralInfoFragmentBinding
    private lateinit var mSignInClient : GoogleSignInClient
    private val RC_SIGN_IN = 9001

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpGeneralInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Google sign-up options
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("461568182092-tjmulmdg022d6osbp0c1cdodhgb308lh.apps.googleusercontent.com")
            .requestEmail()
            .build()
        mSignInClient = GoogleSignIn.getClient(requireActivity(), googleSignInOptions)

        // Button events
        binding.btnNext.setOnClickListener {
            if (!binding.etNames.text.isEmpty() && !binding.etLastName1.text.isEmpty() && !binding.etLastName2.text.isEmpty() && !binding.etUsername.text.isEmpty() && !binding.etBirthdate.text.isEmpty()) {
                // Set info on viewModel
                viewModel.setGeneralInfo("name", binding.etNames.text.toString())
                viewModel.setGeneralInfo("firstLastName", binding.etLastName1.text.toString())
                viewModel.setGeneralInfo("secondLastName", binding.etLastName2.text.toString())
                viewModel.setGeneralInfo("username", binding.etUsername.text.toString())
                viewModel.setGeneralInfo("birthDate", binding.etBirthdate.text.toString())
                // Navigate
                if (viewModel.getSelectedBtnId("account") == getString(R.string.soy_un_inversionista_social)) {
                    findNavController().navigate(R.id.action_signUpGeneralInfo_to_signUpMembership)
                } else if (viewModel.getSelectedBtnId("account") == getString(R.string.busco_contactar_con_inversionistas_y_o_organizaciones)) {
                    findNavController().navigate(R.id.action_signUpGeneralInfo_to_signUpNewPassword)
                }
            } else {
                Toast.makeText(activity, "Por favor llena toda la información solicitada.", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnGoogleSignIn.setOnClickListener {
            signIn()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    private fun signIn() {
        Toast.makeText(activity, "Attempted to sign in with Google.", Toast.LENGTH_SHORT).show()
    }

}