package com.ikigai.rideshare.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var tripList = emptyList<Trip>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return tripList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = tripList[position]
        holder.itemView.departure.text = currentItem.departure
        holder.itemView.destination.text = currentItem.destination
        holder.itemView.date.text = currentItem.date
        holder.itemView.time.text = currentItem.time
    }

    fun setData(trip: List<Trip>){
        this.tripList = trip
        notifyDataSetChanged()
    }
}