package com.ikigai.rideshare.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_view.view.*

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
        holder.itemView.departure_txt.text = currentItem.departure
        holder.itemView.destination_txt.text = currentItem.destination
        holder.itemView.date_txt.text = currentItem.date
        holder.itemView.time_txt.text = currentItem.time
        holder.itemView.message_txt.text = currentItem.message

        holder.itemView.row_layout.setOnClickListener {
            val action = ViewTripFragmentDirections.actionViewTripFragmentToViewFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(trip: List<Trip>){
        this.tripList = trip
        notifyDataSetChanged()
    }
}