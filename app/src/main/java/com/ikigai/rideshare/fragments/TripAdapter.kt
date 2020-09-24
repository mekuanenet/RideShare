package com.ikigai.rideshare.db.trip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikigai.rideshare.R
import kotlinx.android.synthetic.main.custom_row.view.*

class TripAdapter : RecyclerView.Adapter<TripAdapter.MyViewHolder>() {

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
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.departure_txt.text = currentItem.departure
        holder.itemView.destination_txt.text = currentItem.destination
        holder.itemView.date_txt.text = currentItem.date
    }

    fun setData(trip: List<Trip>){
        this.tripList = trip
        notifyDataSetChanged()
    }
}