package com.example.securityintegration.Views.Profile.MyProjects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.ProjectList.Project
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.R
import com.example.securityintegration.Views.OrgLookup.ProjectListAdapter

class MyProjectListAdapter (var prArray: ArrayList<Project>) : RecyclerView.Adapter<MyProjectListAdapter.MyProjectViewHolder>() {

    var listener : RowListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyProjectListAdapter.MyProjectViewHolder {
        val projectRow = LayoutInflater.from(parent.context).inflate(R.layout.project_row, parent, false)
        return MyProjectViewHolder(projectRow)
    }

    override fun onBindViewHolder(holder: MyProjectListAdapter.MyProjectViewHolder, position: Int) {
        holder.set(prArray[position])
        val view = holder.itemView.findViewById<LinearLayout>(R.id.projLinearLayout)
        view.setOnClickListener {
            listener?.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return prArray.size
    }

    // Refresh changes on orgArray
    fun update(prList: List<Project>?) {
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
    class MyProjectViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvProject = view.findViewById<TextView>(R.id.tvProjectName)
        private val tvProjectCreator = view.findViewById<TextView>(R.id.tvProjectCreator)
        private val tvProjectDesc = view.findViewById<TextView>(R.id.tvProjectDesc)

        fun set(project: Project) {
            tvProject.text = project.name
            tvProjectCreator.text = project.org.name
            tvProjectDesc.text = project.desc
        }
    }

}