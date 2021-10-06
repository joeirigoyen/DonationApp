package com.example.securityintegration.Views.OrgLookup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.OrgLookup.OrgLookupViewModel

class OrgLookupFragment : Fragment() {

    companion object {
        fun newInstance() = OrgLookupFragment()
    }

    private val viewModel: OrgLookupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.org_lookup_fragment, container, false)
    }
}