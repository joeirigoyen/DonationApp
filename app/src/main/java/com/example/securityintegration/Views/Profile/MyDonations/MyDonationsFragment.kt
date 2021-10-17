package com.example.securityintegration.Views.Profile.MyDonations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.Models.User.APIService
import com.example.securityintegration.ViewModels.Profile.MyDonationsViewModel
import com.example.securityintegration.databinding.MyDonationsFragmentBinding

class MyDonationsFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = MyDonationsFragment()
    }

    private lateinit var binding: MyDonationsFragmentBinding
    private val viewModel: MyDonationsViewModel by viewModels()
    private val adapter = MyDonationsAdapter(arrayListOf())
    private val space = 20
    //private val users = APIService().getUsers()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyDonationsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Observers, events and adapter
        configObservers()
        configAdapter()
        configEvents()
        adapter.listener = this
    }

    private fun configEvents() {
        // Set element info to boxes
        //viewModel.getDonations(users[0])
    }

    private fun configObservers() {
        viewModel.donationList.observe(viewLifecycleOwner) {
                projectList -> adapter.update(projectList)
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