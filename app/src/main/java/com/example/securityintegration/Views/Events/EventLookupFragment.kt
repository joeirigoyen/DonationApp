package com.example.securityintegration.Views.Events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Events.EventLookupViewModel

class EventLookupFragment : Fragment() {

    companion object {
        fun newInstance() = EventLookupFragment()
    }

    private val viewModel: EventLookupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_lookup_fragment, container, false)
    }

}