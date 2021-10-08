package com.example.securityintegration.Views.OrgLookup

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.OrgLookup.OrgInfoViewModel
import com.example.securityintegration.databinding.OrgInfoFragmentBinding
import com.paypal.android.sdk.payments.*
import java.math.BigDecimal

class OrgInfoFragment : Fragment() {

    // Set binding, viewModel and fragment args
    private lateinit var binding : OrgInfoFragmentBinding
    private val viewModel : OrgInfoViewModel by viewModels()
    private val args : OrgInfoFragmentArgs by navArgs()
    // Set PayPal configuration
    val clientKey : String = "Af-trtxiJXuajGbGYbvIC4jEcBLwiysZBd1w2AWSQY-1JZfM3qIqX9oxU5XrOBCBI68EkTnhkgC1eff7"
    private val config : PayPalConfiguration = PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(clientKey)
    // Set PayPal elements
    private var amountEdt : EditText? = null
    private var payPalBtn : Button? = null
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data : Intent? = result.data
            val confirm = data?.getParcelableExtra<Intent>(PaymentActivity.EXTRA_RESULT_CONFIRMATION)
            if (confirm != null) {
                println("Good")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set info
        configView()
        // Set PayPal button
        amountEdt = requireActivity().findViewById<EditText>(R.id.idEdtAmount)
        payPalBtn = requireActivity().findViewById<Button>(R.id.idBtnPay)
        payPalBtn?.setOnClickListener {
            makePayment(it)
        }
    }

    private fun makePayment(view: View) {
        val amount = amountEdt?.text.toString()
        Toast.makeText(activity, amount, Toast.LENGTH_SHORT).show()
        val intent = Intent(requireActivity(), PayPalService().javaClass)

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        requireActivity().startService(intent)

        val payment = PayPalPayment(amount.toBigDecimal(), "USD", "Donación", PayPalPayment.PAYMENT_INTENT_AUTHORIZE)
        val paymentConfig = Intent(requireActivity(), PaymentActivity().javaClass)

        paymentConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config)
        paymentConfig.putExtra(PaymentActivity.EXTRA_PAYMENT, payment)

        resultLauncher.launch(paymentConfig)
    }

    private fun configView() {
        binding.tvOrgTitle.text = args.selectedOrg.name
        binding.tvOrgDescription.text = args.selectedOrg.desc
        binding.tvOriginDate.text = args.selectedOrg.creationDate.date.toString()
        binding.tvNativeCountry.text = args.selectedOrg.nativeCountry
    }

}