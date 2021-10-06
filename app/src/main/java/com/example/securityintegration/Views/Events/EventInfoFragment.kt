package com.example.securityintegration.Views.Events

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.securityintegration.ViewModels.Events.EventInfoViewModel
import com.example.securityintegration.R

class EventInfoFragment : Fragment() {

    companion object {
        fun newInstance() = EventInfoFragment()
    }

    private lateinit var viewModel: EventInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.event_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EventInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}