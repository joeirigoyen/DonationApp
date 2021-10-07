package com.example.securityintegration.Views.Projects

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Projects.ProjectLookupViewModel

class ProjectLookupFragment : Fragment() {

    companion object {
        fun newInstance() = ProjectLookupFragment()
    }

    private val viewModel: ProjectLookupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.project_lookup_fragment, container, false)
    }

}