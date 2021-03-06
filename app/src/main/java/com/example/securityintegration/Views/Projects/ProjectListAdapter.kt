package com.example.securityintegration.Views.OrgLookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.R

// Provides info to populate OrgList RecyclerView
class ProjectListAdapter (var prArray: ArrayList<Project>) : RecyclerView.Adapter<ProjectListAdapter.ProjectViewHolder>() {

    var listener : RowListener? = null

    // Create and provide boxes to RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectViewHolder {
        val eventRow = LayoutInflater.from(parent.context).inflate(R.layout.project_row, parent, false)
        return ProjectViewHolder(eventRow)
    }

    // Pass info from a box given it's index
    override fun onBindViewHolder(holder: ProjectViewHolder, pos: Int) {
        holder.set(prArray[pos])
        val view = holder.itemView.findViewById<LinearLayout>(R.id.projLinearLayout)
        view.setOnClickListener {
            listener?.onClick(pos)
        }
    }

    // Return item count within the orgArray ArrayList
    override fun getItemCount(): Int {
        return prArray.size
    }

    // Refresh changes on orgArray
    fun setData(prList: List<Project>?) {
        // Free memory
        prArray.clear()
        // Update elements
        if (prList != null) {
            prArray.addAll(prList)
        }
        // Notify changes to RecyclerView
        notifyDataSetChanged()
    }

    // Represents a box within the RecyclerView where view comes from event_row.xml
    class ProjectViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvProject = view.findViewById<TextView>(R.id.tvProjectName)
        private val tvProjectCreator = view.findViewById<TextView>(R.id.tvProjectCreator)
        private val tvProjectDesc = view.findViewById<TextView>(R.id.tvProjectDesc)

        fun set(project: Project) {
            tvProject.text = project.nombre
            tvProjectCreator.text = project.org_creadora
            tvProjectDesc.text = project.descripcion
        }
    }
}