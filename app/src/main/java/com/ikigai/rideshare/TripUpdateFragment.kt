package com.ikigai.rideshare

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ikigai.rideshare.db.trip.Trip
import com.ikigai.rideshare.db.trip.TripViewModel
import com.ikigai.rideshare.fragments.ViewFragmentArgs
import kotlinx.android.synthetic.main.fragment_trip_update.*
import kotlinx.android.synthetic.main.fragment_trip_update.view.*


class TripUpdateFragment : Fragment() {

    private val args by navArgs<TripUpdateFragmentArgs>()
    private lateinit var tripViewMode: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_trip_update, container, false)

        tripViewMode = ViewModelProvider(this).get(TripViewModel::class.java)

        view.view_update_from_et.setText(args.currentValueForUpdate.departure)
        view.view_update_to_et.setText(args.currentValueForUpdate.destination)
        view.view_update_date_et.setText(args.currentValueForUpdate.date)
        view.view_update_time_et.setText(args.currentValueForUpdate.time)
        view.view_update_traveler_et.setText(args.currentValueForUpdate.no_of_travelers)
        view.view_update_message_et.setText(args.currentValueForUpdate.message)

        view.view_update_update.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val departure = view_update_from_et.text.toString()
        val destination = view_update_to_et.text.toString()
        val date = view_update_date_et.text.toString()
        val time = view_update_time_et.text.toString()
        val travelers = view_update_traveler_et.text.toString()
        val message = view_update_message_et.text.toString()

        if (inputCheck(departure, destination, date, time, travelers, message)) {
            // Create Trip Object
            val updatedTrip = Trip(args.currentValueForUpdate.id, args.currentValueForUpdate.poster, departure,
                destination, date, time, travelers, message, args.currentValueForUpdate.email, args.currentValueForUpdate.phone)
            // Update Current User
            tripViewMode.updateTrip(updatedTrip)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_viewFragment_to_viewTripFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(from: String, to: String, date: String,
                           time: String, traveler: String, message: String): Boolean{
        return !(TextUtils.isEmpty(from) && TextUtils.isEmpty(to)
                && TextUtils.isEmpty(date) && TextUtils.isEmpty(time)
                && TextUtils.isEmpty(traveler) && TextUtils.isEmpty(message))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteTrip()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteTrip() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            tripViewMode.deleteTrip(args.currentValueForUpdate)
            Toast.makeText(
                requireContext(),
                "Successfully removed: from ${args.currentValueForUpdate.departure} to ${args.currentValueForUpdate.destination}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_viewFragment_to_viewTripFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete Trip from ${args.currentValueForUpdate.departure} to ${args.currentValueForUpdate.destination}?")
        builder.setMessage("Are you sure you want to delete Trip from ${args.currentValueForUpdate.departure} to ${args.currentValueForUpdate.destination}?")
        builder.create().show()
    }
}