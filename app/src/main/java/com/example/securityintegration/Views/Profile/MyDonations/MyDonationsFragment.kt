package com.example.securityintegration.Views.Profile.MyDonations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.API.APIService
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.Models.User.Donation.DonationInput
import com.example.securityintegration.ViewModels.API.APIViewModel
import com.example.securityintegration.ViewModels.API.ViewModelFactory
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.MyDonationsFragmentBinding

class MyDonationsFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = MyDonationsFragment()
    }

    private lateinit var binding: MyDonationsFragmentBinding
    private lateinit var viewModel: APIViewModel
    private val adapter = MyDonationsAdapter(arrayListOf())
    private val space = 20
    lateinit var act : MainPageActivity
    //private val users = APIService().getUsers()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyDonationsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val service = APIService()
        val viewModelFactory = ViewModelFactory(service)

        viewModel = ViewModelProvider(requireActivity(), viewModelFactory).get(APIViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Events and adapter
        configAdapter()
        configEvents()
        adapter.listener = this
    }

    private fun configEvents() {
        // Get activity variables
        if (activity != null) {
            act = activity as MainPageActivity
            val user = DonationInput(act.accUsername)
            viewModel.postGetDonations(user)
            viewModel.donationsResponse.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {
                    response.body()?.let {
                        adapter.update(it)
                    }
                }
            })
        }
    }

    private fun configAdapter() {
        val recyclerView = binding.rvDonationList
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick(pos: Int) {
        val donation = adapter.donArray[pos]
    }
}