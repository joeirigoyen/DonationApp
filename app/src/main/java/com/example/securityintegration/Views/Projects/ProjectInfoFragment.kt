package com.example.securityintegration.Views.Projects

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Projects.ProjectInfoViewModel
import com.example.securityintegration.Views.Landing.MainPageActivity
import com.example.securityintegration.databinding.ProjectInfoFragmentBinding

class ProjectInfoFragment : Fragment() {

    private lateinit var act : MainPageActivity
    private val args : ProjectInfoFragmentArgs by navArgs()
    private lateinit var binding : ProjectInfoFragmentBinding
    private val viewModel : ProjectInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProjectInfoFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configView()
        configObservers()
    }

    private fun configObservers() {
        // Button onClickListener
        val btn = binding.btnRegisterToProject
        btn.setOnClickListener {
            if (btn.isChecked) {
                btn.setBackgroundResource(R.drawable.toggle_rect_on)
            } else {
                btn.setBackgroundResource(R.drawable.toggle_rect_off)
            }
        }
        binding.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_projectInfoFragment_to_projectListFragment2)
        }
    }

    private fun configView() {
        binding.tvProjTitle.text = args.selectedProject.nombre
        binding.tvProjLookupDescription.text = args.selectedProject.descripcion
        binding.tvProjectCreator.text = args.selectedProject.org_creadora
        if (activity != null) {
            act = activity as MainPageActivity
            if (act.accType == 1) {
                binding.btnRegisterToProject.visibility = View.VISIBLE
            } else {
                binding.btnRegisterToProject.visibility = View.GONE
            }
        }
    }

}