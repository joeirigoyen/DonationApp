package com.example.securityintegration.Views.OrgLookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.Models.User.Login.User
import com.example.securityintegration.R

// Provides info to populate OrgList RecyclerView
class OrgListAdapter (var orgArray: ArrayList<User>) : RecyclerView.Adapter<OrgListAdapter.OrgViewHolder>() {
    // Create row listener
    var listener: RowListener? = null

    // Create and provide boxes to RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrgViewHolder {
        val orgRow = LayoutInflater.from(parent.context).inflate(R.layout.org_row, parent, false)
        return OrgViewHolder(orgRow)
    }

    // Pass info from a box given it's index
    override fun onBindViewHolder(holder: OrgViewHolder, pos: Int) {
        // Set info
        holder.set(orgArray[pos])
        // Set onClick listener
        val view = holder.itemView.findViewById<LinearLayout>(R.id.orgLinearLayout)
        view.setOnClickListener {
            // Notify click to fragment
            listener?.onClick(pos)
        }
    }

    // Return item count within the orgArray ArrayList
    override fun getItemCount(): Int {
        return orgArray.size
    }

    // Refresh changes on orgArray
    fun setData(orgList: List<User>?) {
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
    class OrgViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvOrg = view.findViewById<TextView>(R.id.tvOrgName)
        private val tvOrgDesc = view.findViewById<TextView>(R.id.tvOrgDesc)

        fun set(org: User) {
            tvOrg.text = org.nombre
            tvOrgDesc.text = org.descripcion
        }
    }
}