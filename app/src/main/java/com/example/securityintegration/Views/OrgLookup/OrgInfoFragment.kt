package com.example.securityintegration.Views.OrgLookup

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
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
import com.paypal.checkout.approve.OnApprove
import com.paypal.checkout.cancel.OnCancel
import com.paypal.checkout.createorder.CreateOrder
import com.paypal.checkout.createorder.CurrencyCode
import com.paypal.checkout.createorder.OrderIntent
import com.paypal.checkout.createorder.UserAction
import com.paypal.checkout.error.OnError
import com.paypal.checkout.order.Amount
import com.paypal.checkout.order.AppContext
import com.paypal.checkout.order.Order
import com.paypal.checkout.order.PurchaseUnit
import com.paypal.checkout.paymentbutton.PayPalButton
import java.math.BigDecimal

class OrgInfoFragment : Fragment() {

    // Set binding, viewModel and fragment args
    private lateinit var binding : OrgInfoFragmentBinding
    private val viewModel : OrgInfoViewModel by viewModels()
    private val args : OrgInfoFragmentArgs by navArgs()
    // Set PayPal configuration
    private val clientKey : String = "Af-trtxiJXuajGbGYbvIC4jEcBLwiysZBd1w2AWSQY-1JZfM3qIqX9oxU5XrOBCBI68EkTnhkgC1eff7"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        configButtons()
    }

    private fun configView() {
        binding.tvOrgTitle.text = args.selectedOrg.name
        binding.tvOrgDescription.text = args.selectedOrg.desc
        binding.tvOriginDate.text = args.selectedOrg.creationDate.date.toString()
        binding.tvNativeCountry.text = args.selectedOrg.nativeCountry
    }

    private fun configButtons() {
        // Set PayPal button
        val amountEdt = requireActivity().findViewById<EditText>(R.id.idEdtAmount)
        val payPalButton = requireActivity().findViewById<PayPalButton>(R.id.payPalButton)
        if (amountEdt.text != null) {
            payPalButton?.setup(
                createOrder = CreateOrder { createOrderActions ->
                    val order = Order(
                        intent = OrderIntent.CAPTURE,
                        appContext = AppContext(
                            userAction = UserAction.PAY_NOW
                        ),
                        purchaseUnitList = listOf(
                            PurchaseUnit(
                                amount = Amount(
                                    currencyCode = CurrencyCode.USD,
                                    value = amountEdt?.text.toString()
                                )
                            )
                        )
                    )
                    createOrderActions.create(order)
                },
                onApprove = OnApprove { approval ->
                    approval.orderActions.capture { captureOrderResult ->
                        Log.i("CaptureOrder", "CaptureOrderResult: $captureOrderResult")
                        Toast.makeText(requireContext(), "¡Gracias por tu donación de \$${amountEdt.text}!", Toast.LENGTH_SHORT).show()
                    }
                },
                onCancel = OnCancel {
                    Toast.makeText(requireContext(), "Compra cancelada.", Toast.LENGTH_SHORT).show()
                },
                onError = OnError {
                    Toast.makeText(requireContext(), "Error en la compra", Toast.LENGTH_SHORT).show()
                }
            )
        } else {
            Toast.makeText(requireContext(), "Por favor especifica un monto.", Toast.LENGTH_SHORT).show()
        }
    }

}