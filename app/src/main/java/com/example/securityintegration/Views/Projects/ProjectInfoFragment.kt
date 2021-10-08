package com.example.securityintegration.Views.Projects

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Projects.ProjectInfoViewModel
import com.example.securityintegration.databinding.ProjectInfoFragmentBinding
import okio.ByteString.Companion.decodeHex

class ProjectInfoFragment : Fragment() {

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
    }

    private fun configView() {
        binding.tvProjectTitle.text = args.selectedProject.name
        binding.tvProjLookupDescription.text = args.selectedProject.desc
        binding.tvProjectCreator.text = args.selectedProject.org.name
    }

}