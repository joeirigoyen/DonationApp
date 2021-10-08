package com.example.securityintegration.Views.Profile.MyProjects

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Profile.ProfileLookupViewModel

class ProfileLookupFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileLookupFragment()
    }

    private lateinit var viewModel: ProfileLookupViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_lookup_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileLookupViewModel::class.java)
        // TODO: Use the ViewModel
    }

}