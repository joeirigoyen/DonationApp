package com.example.securityintegration.Views.OrgLookup

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.User.Donation.DonationCreator
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.OrgInfoFragmentBinding
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrgInfoFragment : Fragment() {

    // Set binding, viewModel and fragment args
    private lateinit var binding : OrgInfoFragmentBinding
    private lateinit var viewModel : APIViewModel
    private val args : OrgInfoFragmentArgs by navArgs()
    lateinit var act : MainPageActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        configButtons()
    }

    private fun configView() {
        binding.tvOrgTitle.text = args.selectedOrg.nombre
        binding.tvOrgDescription.text = args.selectedOrg.descripcion
        binding.tvOriginDate.text = args.selectedOrg.fecha_nacimiento
        binding.tvNativeCountry.text = args.selectedOrg.pais
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun configButtons() {
        // Back button
        binding.btnBack.setOnClickListener {
            val action = OrgInfoFragmentDirections.actionOrgInfoFragmentToOrgListFragment()
            findNavController().navigate(action)
        }
        // Set PayPal button
        if (activity != null) {
            act = activity as MainPageActivity
            val amountEdt = requireActivity().findViewById<EditText>(R.id.idEdtAmount)
            val payPalButton = requireActivity().findViewById<PayPalButton>(R.id.payPalButton)
            if (act.accType == 2) {
                amountEdt.visibility = View.GONE
                payPalButton.visibility = View.GONE
            } else {
                amountEdt.visibility = View.VISIBLE
                payPalButton.visibility = View.VISIBLE
            }
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
                                    value = amountEdt?.text.toString() ?: "0"
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
                        val date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                        val donation = DonationCreator(amountEdt?.text.toString().toFloat(), binding.tvOrgTitle.text.toString(), date, act.accUsername)
                        viewModel.postDonation(donation)
                    }
                },
                onCancel = OnCancel {
                    Toast.makeText(requireContext(), "Compra cancelada.", Toast.LENGTH_SHORT).show()
                },
                onError = OnError {
                    Toast.makeText(requireContext(), "Error en la compra", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}