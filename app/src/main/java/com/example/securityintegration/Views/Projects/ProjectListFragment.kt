package com.example.securityintegration.Views.Projects

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventListViewModel
import com.example.securityintegration.ViewModels.Projects.ProjectListViewModel
import com.example.securityintegration.Views.OrgLookup.EventListAdapter
import com.example.securityintegration.Views.OrgLookup.ProjectListAdapter
import com.example.securityintegration.databinding.EventListFragmentBinding
import com.example.securityintegration.databinding.ProjectListFragmentBinding

class ProjectListFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = ProjectListFragment()
    }

    private lateinit var binding: ProjectListFragmentBinding
    private val viewModel: ProjectListViewModel by viewModels()
    private val adapter = ProjectListAdapter(arrayListOf())
    private val space = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectListFragmentBinding.inflate(layoutInflater)
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
        viewModel.getProjects()
    }

    private fun configObservers() {
        viewModel.eventList.observe(viewLifecycleOwner) {
                projectList -> adapter.update(projectList)
        }
    }

    private fun configAdapter() {
        val recyclerView = binding.rvProjectList
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun onClick(pos: Int) {
        val project = adapter.prArray[pos]
        val action = ProjectListFragmentDirections.actionProjectListFragmentToProjectInfoFragment(project)
        findNavController().navigate(action)
    }
}