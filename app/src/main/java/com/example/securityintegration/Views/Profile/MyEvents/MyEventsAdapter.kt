package com.example.securityintegration.Views.Profile.MyEvents

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.securityintegration.Models.EventList.Event
import com.example.securityintegration.Models.RowListener
import com.example.securityintegration.R

class MyEventsAdapter (var evArray: ArrayList<Event>) : RecyclerView.Adapter<MyEventsAdapter.MyEventsViewHolder>() {

    var listener : RowListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEventsAdapter.MyEventsViewHolder {
        val eventRow = LayoutInflater.from(parent.context).inflate(R.layout.event_row, parent, false)
        return MyEventsViewHolder(eventRow)
    }

    override fun onBindViewHolder(holder: MyEventsAdapter.MyEventsViewHolder, position: Int) {
        holder.set(evArray[position])
        val view = holder.itemView.findViewById<LinearLayout>(R.id.eventLinearLayout)
        view.setOnClickListener {
            listener?.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return evArray.size
    }

    // Refresh changes on orgArray
    fun update(evList: List<Event>?) {
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
    class MyEventsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        private val tvEvent = view.findViewById<TextView>(R.id.tvEventName)
        private val tvEventCreator = view.findViewById<TextView>(R.id.tvEventCreator)
        private val tvEventDate = view.findViewById<TextView>(R.id.tvEventDate)

        fun set(event: Event) {
            tvEvent.text = event.name
            tvEventCreator.text = event.creator.name
            tvEventDate.text = event.date.toString()
        }
    }

}