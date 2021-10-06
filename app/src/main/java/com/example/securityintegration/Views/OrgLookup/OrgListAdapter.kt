package com.example.securityintegration.Views.OrgLookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.OrgLookup.Org
import com.example.securityintegration.R

// Provides info to populate OrgList RecyclerView
class OrgListAdapter (var orgArray: ArrayList<Org>) : RecyclerView.Adapter<OrgListAdapter.OrgViewHolder>() {

    private lateinit var mListener : onItemClickListener

    // Create interface for onItemClick
    interface onItemClickListener {

        fun onItemClick(pos: Int) {

        }
    }

    fun setOnItemClickListener (listener: onItemClickListener){

        mListener = listener

    }

    // Create and provide boxes to RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrgViewHolder {
        val orgRow = LayoutInflater.from(parent.context).inflate(R.layout.org_row, parent, false)
        return OrgViewHolder(orgRow, mListener)
    }

    // Pass info from a box given it's index
    override fun onBindViewHolder(holder: OrgViewHolder, pos: Int) {
        holder.set(orgArray[pos])
    }

    // Return item count within the orgArray ArrayList
    override fun getItemCount(): Int {
        return orgArray.size
    }

    // Refresh changes on orgArray
    fun update(orgList: List<Org>?) {
        // Free memory
        orgArray.clear()
        // Update elements
        if (orgList != null) {
            orgArray.addAll(orgList)
        }
        // Notify changes to RecyclerView
        notifyDataSetChanged()
    }

    // Represents a box within the RecyclerView where view comes from org_row.xml
    class OrgViewHolder (view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        private val tvOrg = view.findViewById<TextView>(R.id.tvOrgName)
        private val tvOrgDesc = view.findViewById<TextView>(R.id.tvOrgDesc)

        init {
            view.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun set(org: Org) {
            tvOrg.text = org.name
            tvOrgDesc.text = org.desc
        }
    }
}