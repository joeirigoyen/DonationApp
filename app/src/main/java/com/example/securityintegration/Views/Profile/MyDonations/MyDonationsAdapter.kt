package com.example.securityintegration.Views.Profile.MyDonations

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.Models.User.Donation
import com.example.securityintegration.R
import com.example.securityintegration.ViewModels.Profile.MyDonationsAdapterViewModel
import com.example.securityintegration.Views.Profile.MyProjects.MyProjectListAdapter

class MyDonationsAdapter (var donArray: ArrayList<Donation>) : RecyclerView.Adapter<MyDonationsAdapter.MyDonationsViewHolder>() {

    var listener : RowListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDonationsAdapter.MyDonationsViewHolder {
        val donationRow = LayoutInflater.from(parent.context).inflate(R.layout.donation_row, parent, false)
        return MyDonationsViewHolder(donationRow)
    }

    override fun onBindViewHolder(holder: MyDonationsAdapter.MyDonationsViewHolder, position: Int) {
        holder.set(donArray[position])
        val view = holder.itemView.findViewById<LinearLayout>(R.id.donLinearLayout)
        view.setOnClickListener {
            listener?.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return donArray.size
    }

    // Refresh changes on orgArray
    fun update(donList: List<Donation>?) {
        // Free memory
        donArray.clear()
        // Update elements
        if (donList != null) {
            donArray.addAll(donList)
        }
        // Notify changes to RecyclerView
        notifyDataSetChanged()
    }

    // Represents a box within the RecyclerView where view comes from event_row.xml
    class MyDonationsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvDestination = view.findViewById<TextView>(R.id.tvDonationDest)
        private val tvAmount = view.findViewById<TextView>(R.id.tvDonationAmount)
        private val tvDate = view.findViewById<TextView>(R.id.tvDonationDate)

        fun set(donation: Donation) {
            tvDestination.text = "Donaste a ${donation.destination.name}"
            tvAmount.text = "\$${donation.amount.toEngineeringString()}"
            tvDate.text = donation.date.toString()
        }
    }

}