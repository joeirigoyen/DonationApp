package com.example.securityintegration.Views.OrgLookup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.ViewModels.OrgLookup.OrgListViewModel
import com.example.securityintegration.databinding.OrgListFragmentBinding

class OrgListFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = OrgListFragment()
    }

    private lateinit var binding: OrgListFragmentBinding
    private val viewModel: OrgListViewModel by viewModels()
    private val adapter = OrgListAdapter(arrayListOf())
    private val space = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OrgListFragmentBinding.inflate(layoutInflater)
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
        viewModel.getOrgs()
    }

    private fun configObservers() {
        viewModel.orgList.observe(viewLifecycleOwner) { orgList ->
            adapter.update(orgList)
        }
    }

    private fun configAdapter() {
        // Get recycler view
        val recyclerView = binding.rvOrgList
        // Set margin
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        // Set adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick(pos: Int) {
        // Switch screen
        val org = adapter.orgArray[pos]
        val action = OrgListFragmentDirections.actionOrgListFragmentToOrgInfoFragment3(org)
        findNavController().navigate(action)
    }
}