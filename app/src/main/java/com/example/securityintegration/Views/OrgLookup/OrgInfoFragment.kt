package com.example.securityintegration.Views.OrgLookup

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.OrgInfoViewModel

class OrgInfoFragment : Fragment() {

    companion object {
        fun newInstance() = OrgInfoFragment()
    }

    private val viewModel: OrgInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.org_info_fragment, container, false)
    }

}