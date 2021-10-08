package com.example.securityintegration.Views.Profile.MyProjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.securityintegration.Models.OrgLookup.MarginItemDecoration
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.Models.User.User
import com.example.securityintegration.Models.User.UserService
import com.example.securityintegration.ViewModels.Profile.MyProjectsViewModel
import com.example.securityintegration.databinding.MyProjectsFragmentBinding
import java.sql.Date

class MyProjectsFragment : Fragment(), RowListener {

    companion object {
        fun newInstance() = MyProjectsFragment()
    }

    private lateinit var binding: MyProjectsFragmentBinding
    private val viewModel: MyProjectsViewModel by viewModels()
    private val adapter = MyProjectListAdapter(arrayListOf())
    private val space = 20

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MyProjectsFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configObservers()
        configAdapter()
        configEvents()
        adapter.listener = this
    }

    private fun configAdapter() {
        val recyclerView = binding.rvMyProjectList
        recyclerView.addItemDecoration(
            MarginItemDecoration(space)
        )
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun configEvents() {
        viewModel.getProjects(UserService().getUsers()[0])
    }

    private fun configObservers() {
        viewModel.projectList.observe(viewLifecycleOwner) {
            projectList -> adapter.update(projectList)
        }
    }

    override fun onClick(pos: Int) {
        val project = adapter.prArray[pos]
        val action = MyProjectsFragmentDirections.actionMyProjectsFragmentToProjectInfoFragment2(project)
        findNavController().navigate(action)
    }

}