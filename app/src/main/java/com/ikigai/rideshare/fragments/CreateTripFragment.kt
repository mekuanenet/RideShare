package com.ikigai.rideshare.fragments

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import com.ikigai.rideshare.db.trip.TripViewModel
import com.ikigai.rideshare.db.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_create_trip.*
import kotlinx.android.synthetic.main.fragment_create_trip.view.*
import java.util.*


class CreateTripFragment : Fragment() {

    private lateinit var tripViewModel: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_trip, container, false)

        tripViewModel =  ViewModelProvider(this).get(TripViewModel::class.java)

        view.add_trip_button.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val poster = posted_by_et.text.toString()
        val from = from_et.text.toString()
        val to = to_et.text.toString()
        val date = date_et.text.toString()
        val time = time_et.text.toString()
        val traveler = traveler_et.text.toString()
        val message = message_et.text.toString()
        val email = email_et.text.toString()
        val phone = phone_et.text.toString()

        if(inputCheck(from, to, date, time, traveler, message)){
            // Create User Object
            val trip = Trip(0, poster,from, to, date, time, traveler, message, email, phone)
            // Add Data to Database
            tripViewModel.addTrip(trip)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_createTripFragment_to_viewTripFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(from: String, to: String, date: String,
                           time: String, traveler: String, message: String): Boolean{
        return !(TextUtils.isEmpty(from) && TextUtils.isEmpty(to)
                && TextUtils.isEmpty(date) && TextUtils.isEmpty(time)
                && TextUtils.isEmpty(traveler) && TextUtils.isEmpty(message))
    }
}