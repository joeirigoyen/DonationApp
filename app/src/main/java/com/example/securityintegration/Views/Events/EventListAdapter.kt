package com.example.securityintegration.Views.OrgLookup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.EventList.RowListener
import com.example.securityintegration.R

// Provides info to populate OrgList RecyclerView
class EventListAdapter (var evArray: ArrayList<Event>) : RecyclerView.Adapter<EventListAdapter.EventViewHolder>() {

    var listener : RowListener? = null

    // Create and provide boxes to RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val eventRow = LayoutInflater.from(parent.context).inflate(R.layout.event_row, parent, false)
        return EventViewHolder(eventRow)
    }

    // Pass info from a box given it's index
    override fun onBindViewHolder(holder: EventViewHolder, pos: Int) {
        // Set info
        holder.set(evArray[pos])
        // Set onClick listener
        val view = holder.itemView.findViewById<LinearLayout>(R.id.eventLinearLayout)
        view.setOnClickListener {
            // Notify click to fragment
            listener?.onClick(pos)
        }
    }

    // Return item count within the orgArray ArrayList
    override fun getItemCount(): Int {
        return evArray.size
    }

    // Refresh changes on orgArray
    fun setData(evList: List<Event>?) {
        // Free memory
        evArray.clear()
        // Update elements
        if (evList != null) {
            evArray.addAll(evList)
        }
        // Notify changes to RecyclerView
        notifyDataSetChanged()
    }

    // Represents a box within the RecyclerView where view comes from event_row.xml
    class EventViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvEvent = view.findViewById<TextView>(R.id.tvEventName)
        private val tvEventDate = view.findViewById<TextView>(R.id.tvEventDate)
        private val tvEventCreator = view.findViewById<TextView>(R.id.tvEventCreator)

        fun set(event: Event) {
            tvEvent.text = event.nombre
            tvEventDate.text = event.fecha_evento
            tvEventCreator.text = event.org_creadora
        }
    }
}