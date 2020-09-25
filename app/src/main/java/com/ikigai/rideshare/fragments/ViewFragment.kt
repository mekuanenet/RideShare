package com.ikigai.rideshare.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ikigai.rideshare.R
import com.ikigai.rideshare.db.trip.Trip
import com.ikigai.rideshare.db.trip.TripViewModel
import kotlinx.android.synthetic.main.fragment_trip_list.view.*
import kotlinx.android.synthetic.main.fragment_view.*
import kotlinx.android.synthetic.main.fragment_view.view.*


class ViewFragment : Fragment() {

    private val args by navArgs<ViewFragmentArgs>()
    private lateinit var tripViewMode: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view, container, false)

        tripViewMode = ViewModelProvider(this).get(TripViewModel::class.java)
        view.view_posted_by_et.setText(args.currentTrip.poster)
        view.view_from_et.setText(args.currentTrip.departure)
        view.view_to_et.setText(args.currentTrip.destination)
        view.view_date_et.setText(args.currentTrip.date)
        view.view_time_et.setText(args.currentTrip.time)
        view.view_traveler_et.setText(args.currentTrip.no_of_travelers)
        view.view_message_et.setText(args.currentTrip.message)
        view.view_email_et.setText(args.currentTrip.email)
        view.view_phone_et.setText(args.currentTrip.phone)
//        view.view_update.setOnClickListener {
//            updateItem()
//        }



        // Add menu
//        view.floatingActionButtonTwo.setOnClickListener {
//            findNavController().navigate(R.id.action_viewFragment_to_tripUpdateFragment4)
//        }

        setHasOptionsMenu(true)

        return view
    }

//    private fun updateItem() {
//        val departure = view_from_et.text.toString()
//        val destination = view_to_et.text.toString()
//        val date = view_date_et.text.toString()
//        val time = view_time_et.text.toString()
//        val travelers = view_traveler_et.text.toString()
//        val message = view_message_et.text.toString()
//
//        if (inputCheck(departure, destination, date, time, travelers, message)) {
//            // Create Trip Object
//            val updatedTrip = Trip(
//                args.currentTrip.id, departure, destination, date, time, Integer.parseInt(
//                    travelers
//                ), message
//            )
//            // Update Current User
//            tripViewMode.updateTrip(updatedTrip)
//            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
//            // Navigate Back
//            findNavController().navigate(R.id.action_viewFragment_to_viewTripFragment)
//        } else {
//            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
//                .show()
//        }
//    }
//
//    private fun inputCheck(
//        from: String, to: String, date: String,
//        time: String, traveler: String, message: String
//    ): Boolean{
//        return !(TextUtils.isEmpty(from) && TextUtils.isEmpty(to)
//                && TextUtils.isEmpty(date) && TextUtils.isEmpty(time)
//                && TextUtils.isEmpty(traveler) && TextUtils.isEmpty(message))
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.contact_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.menu_delete) {
//            deleteTrip()
//        }
//        return super.onOptionsItemSelected(item)

        if(R.id.nav_email == item.itemId) {
            composeEmail(Array(1){view_email_et.text.toString()},"I want to share a ride with you!", """
                    Hi ${view_posted_by_et.text.toString()},
                    I saw your post on the RideShare app.
                    I am writing this requesting to share a ride.
                    Thank you!
                """.trimIndent())
        } else if(R.id.nav_text == item.itemId) {

            val phoneCallUri = Uri.parse(view.toString())
            view?.let { composeMmsMessage(it) }
        } else if (R.id.nav_call == item.itemId) {
            dialNumber(view_phone_et.text.toString())
        }
        return super.onOptionsItemSelected(item)

    }

    private fun dialNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:${view_phone_et.text.toString()}")
        }
        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
            startActivity(intent)
        }
    }

    private fun composeMmsMessage(v: View) {
//        val intent = Intent(Intent.ACTION_SEND).apply {
//            data = Uri.parse("smsto:")  // This ensures only SMS apps respond
//            putExtra("sms_body", message)
//            putExtra(Intent.EXTRA_STREAM, attachment)
//        }
//        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
//            startActivity(intent)
//        }
            val uri = Uri.parse("smsto:${view_phone_et.text.toString()}")
            val it = Intent(Intent.ACTION_SENDTO, uri);
            it.putExtra("sms_body", "Hi, I want to share a ride with you!");
            startActivity(it);
        }

    private fun composeEmail(addresses: Array<String>, subject: String, message:String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, message)
        }
        if (activity?.packageManager?.let { intent.resolveActivity(it) } != null) {
            startActivity(intent)
        }
    }
}