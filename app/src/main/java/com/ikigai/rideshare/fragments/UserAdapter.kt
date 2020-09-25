package com.ikigai.rideshare.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import com.ikigai.rideshare.db.user.User
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.fragment_profile.view.*
import kotlinx.android.synthetic.main.user_row.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[userList.size-1]
        val fullName = currentItem.firstName + " " + currentItem.lastName
        holder.itemView.tv_name.text = fullName
        holder.itemView.tv_firstName.text = currentItem.firstName
        holder.itemView.tv_lastName.text = currentItem.lastName
        holder.itemView.tv_phone.text = currentItem.phoneNumber
        holder.itemView.tv_email.text = currentItem.email
    }


    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

    fun getData() : List<User> {
        return userList
    }



}