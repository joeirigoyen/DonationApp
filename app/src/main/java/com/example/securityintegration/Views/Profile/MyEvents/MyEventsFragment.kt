package com.example.securityintegration.Views.Profile.MyEvents

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Profile.MyEventsViewModel

class MyEventsFragment : Fragment() {

    companion object {
        fun newInstance() = MyEventsFragment()
    }

    private lateinit var viewModel: MyEventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_events_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyEventsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}